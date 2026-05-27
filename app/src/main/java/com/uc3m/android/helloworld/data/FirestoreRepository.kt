package com.uc3m.android.helloworld.data

import android.util.Log
import android.util.Log.e
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.tasks.await


class FirestoreRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val completedTestsCollection = firestore.collection("completed_tests")
    private val userConfigCollection = firestore.collection("user_config")

    companion object {
        const val CONFIG_COLLECTION = "config"
        const val SUBJECTS_COLLECTION = "subjects"
        const val UNITS_SUBCOLLECTION = "units"
        const val QUESTIONS_SUBCOLLECTION = "questions"
    }

    // LiveData to hold the list of subjects
    private val _subjectsLiveData = MutableLiveData<List<Subject>>()
    val subjectsLiveData: LiveData<List<Subject>> = _subjectsLiveData

    // LiveData to hold the list of units for a specific subject
    private val _unitsLiveData = MutableLiveData<List<SubjectUnit>>()
    val unitsLiveData: LiveData<List<SubjectUnit>> = _unitsLiveData

    // LiveData to hold the list of questions for a specific unit
    private val _questionsLiveData = MutableLiveData<List<Question>>()
    val questionsLiveData: LiveData<List<Question>> = _questionsLiveData

    // Function to listen for real-time changes in subjects
    fun listenToSubjects(): ListenerRegistration {
        return firestore.collection(SUBJECTS_COLLECTION)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    // Handle error
                    return@addSnapshotListener
                }
                val subjects = snapshot?.documents?.mapNotNull { it.toObject(Subject::class.java) } ?: emptyList()
                _subjectsLiveData.postValue(subjects) // Update LiveData
            }
    }

    // Function to listen for real-time changes in units of a specific subject
    fun listenToUnitsForSubject(subjectId: String): ListenerRegistration {
        return firestore.collection(SUBJECTS_COLLECTION)
            .document(subjectId)
            .collection(UNITS_SUBCOLLECTION)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    // Handle error
                    return@addSnapshotListener
                }
                val units = snapshot?.documents?.mapNotNull { it.toObject(SubjectUnit::class.java) } ?: emptyList()
                _unitsLiveData.postValue(units) // Update LiveData
            }
    }

    // Function to listen for real-time changes in questions of a specific unit
    fun listenToQuestionsForUnit(subjectId: String, unitId: String): ListenerRegistration {
        return firestore.collection(SUBJECTS_COLLECTION)
            .document(subjectId)
            .collection(UNITS_SUBCOLLECTION)
            .document(unitId)
            .collection(QUESTIONS_SUBCOLLECTION)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    // Handle error
                    return@addSnapshotListener
                }
                val questions = snapshot?.documents?.mapNotNull { it.toObject(Question::class.java) } ?: emptyList()
                _questionsLiveData.postValue(questions) // Update LiveData
            }
    }

    // Function to get all subjects (non-listening)
    suspend fun getAllSubjects(): List<Subject> {
        val querySnapshot = firestore.collection(SUBJECTS_COLLECTION)
            .get()
            .await()
        return querySnapshot.documents.mapNotNull { doc -> doc.toObject(Subject::class.java) }
    }

    // Function to get all units from a specific subject (non-listening)
    suspend fun getAllUnitsFromSubject(subjectId: String): List<SubjectUnit> {
        val snapshot = firestore.collection(SUBJECTS_COLLECTION)
            .document(subjectId)
            .collection(UNITS_SUBCOLLECTION)
            .get()
            .await()
        return snapshot.documents.mapNotNull { it.toObject(SubjectUnit::class.java) }
    }


// Function to know if the db has already been initialized
    suspend fun isDatabaseInitializedGlobal(): Boolean {
        val snapshot = firestore
            .collection(CONFIG_COLLECTION)
            .document("initialization")
            .get()
            .await()

        return snapshot.exists() && snapshot.getBoolean("initialized") == true
    }

    //Function to establish that the db has already been initialized
    suspend fun markDatabaseAsInitialized() {
        val data = mapOf(
            "initialized" to true,
            "timestamp" to FieldValue.serverTimestamp()
        )

        firestore
            .collection(CONFIG_COLLECTION)
            .document("initialization")
            .set(data)
            .await()
    }



    // Function to add a Subject if it doesn't exist, using a custom ID
    suspend fun addSubject(subject: Subject, subjectId: String): String {
        // Check if the subject already exists by name
        val existingSubject = getSubjectByName(subject.name)
        return if (existingSubject == null) {
            val docRef = firestore.collection(SUBJECTS_COLLECTION).document(subjectId) // Use Id
            val subjectWithId = subject.copy(id = subjectId)
            docRef.set(subjectWithId).await() // Establish the subject with the ID
            docRef.id
        } else {
            existingSubject.id ?: throw IllegalStateException("Subject ID is null but should not be") // if ID is null
        }
    }



    // Function to get a Subject by name
    suspend fun getSubjectByName(name: String): Subject? {
        val querySnapshot = firestore.collection(SUBJECTS_COLLECTION)
            .whereEqualTo("name", name)
            .get()
            .await()

        return if (querySnapshot.documents.isNotEmpty()) {
            querySnapshot.documents[0].toObject(Subject::class.java)
        } else {
            null
        }
    }

    suspend fun addUnitToSubject(unit: SubjectUnit, subjectId: String): String {
        try {
            // Log to know that we are checking the subject by name
            Log.d("FirestoreDebug", "Checking if unit '${unit.name}' exists in subject with ID '$subjectId'")

            // Check if the unit already exists by name
            val existingUnit = getUnitByName(unit.name, subjectId)

            return if (existingUnit == null) {
                // If the unit does not exist
                Log.d("FirestoreDebug", "Unit '${unit.name}' does not exist. Proceeding to create it.")

                // Used id given
                val unitId = unit.id ?: "default-id-${System.currentTimeMillis()}"

                Log.d("FirestoreDebug", "Using unit ID: $unitId")

                val docRef = firestore.collection(SUBJECTS_COLLECTION)
                    .document(subjectId)
                    .collection(UNITS_SUBCOLLECTION)
                    .document(unitId)

                val unitWithId = unit.copy(id = unit.id)

                // To check that we are writting in firestore
                Log.d("FirestoreDebug", "Writing new unit to Firestore with ID: $unitId")

                docRef.set(unitWithId).await()

                // To know that it works correctly
                Log.d("FirestoreDebug", "Unit successfully added with ID: ${docRef.id}")

                docRef.id
            } else {
                // The unit already exists
                Log.d("FirestoreDebug", "Unit '${unit.name}' already exists. Reusing existing ID: ${existingUnit.id}")
                existingUnit.id ?: throw IllegalStateException("Unit ID is null but should not be") // Reuse existing ID
            }
        } catch (e: Exception) {
            // Handle error
            Log.e("FirestoreDebug", "Error adding unit to subject: ${e.message}", e)
            throw e // Re-throw the exception after logging it
        }
    }





    suspend fun addUnitsToSubject(subjectId: String, units: List<SubjectUnit>) {
        units.forEach { unit ->
            addUnitToSubject(unit, subjectId)
        }
    }

    // Function to get a Unit by name in a specific Subject
    suspend fun getUnitByName(unitName: String, subjectId: String): SubjectUnit? {
        val querySnapshot = firestore.collection(SUBJECTS_COLLECTION)
            .document(subjectId)
            .collection(UNITS_SUBCOLLECTION)
            .whereEqualTo("name", unitName)
            .get()
            .await()

        return if (querySnapshot.documents.isNotEmpty()) {
            querySnapshot.documents[0].toObject(SubjectUnit::class.java)
        } else {
            null
        }
    }

    // Function to add a Question to a Unit in a Subject if it doesn't exist, using a custom ID
    suspend fun addQuestionToUnit(question: Question, subjectId: String, unitId: String) {
        // Check if the question already exists by text (or any other unique identifier)
        val existingQuestion = getQuestionByText(question.questionText, subjectId, unitId)
        if (existingQuestion == null) {
            // Use the id given or generate a new one
            val docRef = firestore.collection(SUBJECTS_COLLECTION)
                .document(subjectId)
                .collection(UNITS_SUBCOLLECTION)
                .document(unitId)
                .collection(QUESTIONS_SUBCOLLECTION)
                .document(question.id ?: "default-id-${System.currentTimeMillis()}")

            val questionWithId = question.copy(id = question.id ?: docRef.id)
            docRef.set(questionWithId).await()
        }
    }


    // Function to get a Question by its text in a specific Unit and Subject
    suspend fun getQuestionByText(questionText: String, subjectId: String, unitId: String): Question? {
        val querySnapshot = firestore.collection(SUBJECTS_COLLECTION)
            .document(subjectId)
            .collection(UNITS_SUBCOLLECTION)
            .document(unitId)
            .collection(QUESTIONS_SUBCOLLECTION)
            .whereEqualTo("questionText", questionText)
            .get()
            .await()

        return if (querySnapshot.documents.isNotEmpty()) {
            querySnapshot.documents[0].toObject(Question::class.java)
        } else {
            null
        }
    }

    // Function to get all questions for a Unit in a Subject
    suspend fun getQuestionsForUnit(subjectId: String, unitId: String): List<Question> {
        val querySnapshot = firestore.collection(SUBJECTS_COLLECTION)
            .document(subjectId)
            .collection(UNITS_SUBCOLLECTION)
            .document(unitId)
            .collection(QUESTIONS_SUBCOLLECTION)
            .get()
            .await()

        return querySnapshot.documents.mapNotNull { doc ->
            doc.toObject(Question::class.java)
        }
    }

    // Function to add multiple questions to a Unit at once if they don't exist
    suspend fun addQuestionsToUnit(questions: List<Question>, subjectId: String, unitId: String) {
        questions.forEach { question ->
            // Only add question if it doesn't already exist
            addQuestionToUnit(question, subjectId, unitId)
        }
    }

    suspend fun resetInitializationFlag() {
        firestore.collection(CONFIG_COLLECTION)
            .document("initialization")
            .delete()
            .await()
    }

    suspend fun getCompletedTests(): Set<String> {
        return try {
            val auth = FirebaseAuth.getInstance()
            val userId = auth.currentUser?.uid ?: return emptySet()
            
            val snapshot = completedTestsCollection
                .document(userId)
                .get()
                .await()
            
            val data = snapshot.data
            if (data != null && data.containsKey("completed")) {
                @Suppress("UNCHECKED_CAST")
                (data["completed"] as? List<String>)?.toSet() ?: emptySet()
            } else {
                emptySet()
            }
        } catch (e: Exception) {
            Log.e("GET_COMPLETED", "Error getting completed tests", e)
            emptySet()
        }
    }

    suspend fun markTestAsCompleted(subjectId: String) {
        try {
            val auth = FirebaseAuth.getInstance()
            val userId = auth.currentUser?.uid ?: return
            
            val userDoc = completedTestsCollection.document(userId)
            val currentData = userDoc.get().await().data
            
            val completedList = if (currentData != null && currentData.containsKey("completed")) {
                @Suppress("UNCHECKED_CAST")
                (currentData["completed"] as? List<String>)?.toMutableList() ?: mutableListOf()
            } else {
                mutableListOf()
            }
            
            if (!completedList.contains(subjectId)) {
                completedList.add(subjectId)
                userDoc.set(mapOf("completed" to completedList))
            }
        } catch (e: Exception) {
            Log.e("MARK_COMPLETED", "Error marking test as completed", e)
        }
    }

    suspend fun getLastResetDate(): java.time.LocalDate? {
        return try {
            val auth = FirebaseAuth.getInstance()
            val userId = auth.currentUser?.uid ?: return null
            
            val snapshot = userConfigCollection
                .document(userId)
                .get()
                .await()
            
            val data = snapshot.data
            if (data != null && data.containsKey("lastResetDate")) {
                val dateStr = data["lastResetDate"] as? String
                dateStr?.let { java.time.LocalDate.parse(it) }
            } else {
                null
            }
        } catch (e: Exception) {
            Log.e("GET_RESET_DATE", "Error getting last reset date", e)
            null
        }
    }

    suspend fun updateLastResetDate(date: java.time.LocalDate) {
        try {
            val auth = FirebaseAuth.getInstance()
            val userId = auth.currentUser?.uid ?: return
            
            userConfigCollection
                .document(userId)
                .set(mapOf("lastResetDate" to date.toString()))
                .await()
        } catch (e: Exception) {
            Log.e("UPDATE_RESET_DATE", "Error updating last reset date", e)
        }
    }

    suspend fun resetCompletedTests() {
        try {
            val auth = FirebaseAuth.getInstance()
            val userId = auth.currentUser?.uid ?: return
            
            completedTestsCollection
                .document(userId)
                .delete()
                .await()
        } catch (e: Exception) {
            Log.e("RESET_TESTS", "Error resetting completed tests", e)
        }
    }

}

