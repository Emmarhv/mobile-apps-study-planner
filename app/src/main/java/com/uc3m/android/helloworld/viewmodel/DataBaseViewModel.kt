package com.uc3m.android.helloworld.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uc3m.android.helloworld.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.delay
import java.time.LocalDate


class DataBaseViewModel : ViewModel() {
    private val repo = FirestoreRepository()


    // ── A. INITIALIZATION ────────────────────────────────────────────────────────
    private val _databaseInitialized = MutableLiveData<Boolean>()
    val isInitialized: LiveData<Boolean> = _databaseInitialized

    fun initializeDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            if (repo.isDatabaseInitializedGlobal()) {
                _databaseInitialized.postValue(true)
                return@launch
            }
            // SEED DATA
            // Subjects -----------------------------------------------------------
            val mathSubject = Subject(name = "Maths")
            val mathId = repo.addSubject(mathSubject, "maths")

            val scienceSubject = Subject(name = "Science")
            val scienceId = repo.addSubject(scienceSubject, "science")

            val geoSubject = Subject(name = "Geography")
            val geoId = repo.addSubject(geoSubject, "geo")

            val historySubject = Subject(name = "History")
            val historyId = repo.addSubject(historySubject, "history")

            val bioSubject = Subject(name = "Biology")
            val bioId = repo.addSubject(bioSubject, "bio")

            val spanishSubject = Subject(name = "Spanish")
            val spanishId = repo.addSubject(spanishSubject, "spanish")

            val englishSubject = Subject(name = "English")
            val englishId = repo.addSubject(englishSubject, "english")

            // Units & Questions ----------------------------------------------------------------
            // Maths ----------------------------------------------------------------------------
            // 1. Algebra
            val algebraUnit = SubjectUnit(name = "Algebra", subjectId = mathId, id = "u1maths")
            val algebraId = repo.addUnitToSubject(algebraUnit, mathId)

            val algebraQuestion = mathQuestions.generateAlgebraQuestions(algebraId)
            repo.addQuestionsToUnit(algebraQuestion, mathId, algebraId)

            // 2. Geometry
            val geometryUnit = SubjectUnit(name = "Geometry", subjectId = mathId, id = "u2maths")
            val geometryId = repo.addUnitToSubject(geometryUnit, mathId)

            val geometryQuestions = mathQuestions.generateGeometryQuestions(geometryId)
            repo.addQuestionsToUnit(geometryQuestions, mathId, geometryId)

            // 3. Functions
            val functionsUnit = SubjectUnit(name = "Functions", subjectId = mathId, id = "u3maths")
            val functionsId = repo.addUnitToSubject(functionsUnit, mathId)

            val functionsQuestions = mathQuestions.generateFunctionsQuestions(functionsId)
            repo.addQuestionsToUnit(functionsQuestions, mathId, functionsId)

            // 4. Statistic and Probability
            val statsUnit = SubjectUnit(name = "Statistics and Probability", subjectId = mathId, id = "u4maths")
            val statsId = repo.addUnitToSubject(statsUnit, mathId)

            val statsQuestions = mathQuestions.generateStatsQuestions(statsId)
            repo.addQuestionsToUnit(statsQuestions, mathId, statsId)

            // 5. Trigonometry
            val trigUnit = SubjectUnit(name = "Trigonometry", subjectId = mathId, id = "u5maths")
            val trigId = repo.addUnitToSubject(trigUnit, mathId)

            val trigQuestions = mathQuestions.generateTrigQuestions(trigId)
            repo.addQuestionsToUnit(trigQuestions, mathId, trigId)

            // 6. Equations
            val equationsUnit = SubjectUnit(name = "Equations and Inequalities", subjectId = mathId, id = "u6maths")
            val equationsId = repo.addUnitToSubject(equationsUnit, mathId)

            val equationsQuestions = mathQuestions.generateEquationsQuestions(equationsId)
            repo.addQuestionsToUnit(equationsQuestions, mathId, equationsId)


            // Science ----------------------------------------------------------------------------
            // 1. Kinematics & Dynamics
            val kinematicsDynamicsUnit = SubjectUnit(name = "Kinematics and Dynamics", subjectId = scienceId, id = "u1science")
            val kinematicsDynamicsId = repo.addUnitToSubject(kinematicsDynamicsUnit, scienceId)

            val kinematicsQuestions = scienceQuestions.generateKinematicsQuestions(kinematicsDynamicsId)
            repo.addQuestionsToUnit(kinematicsQuestions, scienceId, kinematicsDynamicsId)

            // 2. Energy
            val workEnergyPowerUnit = SubjectUnit(name = "Work, Energy, and Power", subjectId = scienceId, id = "u2science")
            val workEnergyPowerId = repo.addUnitToSubject(workEnergyPowerUnit, scienceId)

            val workQuestions = scienceQuestions.generateWorkEnergyPowerQuestions(workEnergyPowerId)
            repo.addQuestionsToUnit(workQuestions, scienceId, workEnergyPowerId)

            // 3. Forces
            val forcesNewtonLawsUnit = SubjectUnit(name = "Forces and Newton's Laws", subjectId = scienceId, id = "u3science")
            val forcesNewtonLawsId = repo.addUnitToSubject(forcesNewtonLawsUnit, scienceId)

            val forcesNewtonLawsQuestions = scienceQuestions.generateForcesNewtonsLawsQuestions(forcesNewtonLawsId)
            repo.addQuestionsToUnit(forcesNewtonLawsQuestions, scienceId, forcesNewtonLawsId)

            // 4. Periodic Table
            val atomicStructurePeriodicTableUnit = SubjectUnit(name = "Atomic Structure and the Periodic Table", subjectId = scienceId, id = "u4science")
            val atomicStructurePeriodicTableId = repo.addUnitToSubject(atomicStructurePeriodicTableUnit, scienceId)

            val periodicTableQuestions = scienceQuestions.generatePeriodicTableQuestions(atomicStructurePeriodicTableId)
            repo.addQuestionsToUnit(periodicTableQuestions, scienceId, atomicStructurePeriodicTableId)

            // 5. Chemical Bonding
            val chemicalBondingUnit = SubjectUnit(name = "Chemical Bonding", subjectId = scienceId, id = "u5science")
            val chemicalBondingId = repo.addUnitToSubject(chemicalBondingUnit, scienceId)

            val chemicalBondingQuestions = scienceQuestions.generateChemicalBondingQuestions(chemicalBondingId)
            repo.addQuestionsToUnit(chemicalBondingQuestions, scienceId, chemicalBondingId)


            // Geography-------------------------------------------------------------------------
            // 1. Physical Geography and Landforms
            val physicalGeographyUnit = SubjectUnit(name = "Physical Geography and Landforms", subjectId = geoId, id = "u1geo")
            val physicalGeographyId = repo.addUnitToSubject(physicalGeographyUnit, geoId)

            val physicalGeographyQuestions = geoQuestions.generatePhysicalGeographyQuestions(physicalGeographyId)
            repo.addQuestionsToUnit(physicalGeographyQuestions, geoId, physicalGeographyId)

            // 2. Climate and Weather Patterns
            val climateUnit = SubjectUnit(name = "Climate and Weather Patterns", subjectId = geoId, id = "u2geo")
            val climateId = repo.addUnitToSubject(climateUnit, geoId)

            val climateQuestions = geoQuestions.generateClimateAndWeatherQuestions(climateId)
            repo.addQuestionsToUnit(climateQuestions, geoId, climateId)

            // 3. Population and Economic Activities
            val populationEconomicsUnit = SubjectUnit(name = "Population and Economic Activities", subjectId = geoId, id = "u3geo")
            val populationEconomicsId = repo.addUnitToSubject(populationEconomicsUnit, geoId)

            val populationEconomicsQuestions = geoQuestions.generatePopulationAndEconomicsQuestions(populationEconomicsId)
            repo.addQuestionsToUnit(populationEconomicsQuestions, geoId, populationEconomicsId)


            // History-------------------------------------------------------------------------
            // 1. Ancient history
            val ancientHistoryUnit = SubjectUnit(name = "Prehistory, Ancient Greece and Rome", subjectId = historyId, id = "u1history")
            val ancientHistoryId = repo.addUnitToSubject(ancientHistoryUnit, historyId)

            val ancientHistoryQuestions = historyQuestions.generateAncientHistoryQuestions(ancientHistoryId)
            repo.addQuestionsToUnit(ancientHistoryQuestions, historyId, ancientHistoryId)

            // 2. Medieval Ages and Renaissance
            val medievalRenaissanceUnit = SubjectUnit(name = "Middle Ages and the Renaissance", subjectId = historyId, id = "u2history")
            val medievalRenaissanceId = repo.addUnitToSubject(medievalRenaissanceUnit, historyId)

            val medievalRenaissanceQuestions = historyQuestions.generateMedievalRenaissanceQuestions(medievalRenaissanceId)
            repo.addQuestionsToUnit(medievalRenaissanceQuestions, historyId, medievalRenaissanceId)

            // 3. Modern and Contemporary History
            val modernContemporaryUnit = SubjectUnit(name = "Modern and Contemporary History", subjectId = historyId, id = "u3history")
            val modernContemporaryId = repo.addUnitToSubject(modernContemporaryUnit, historyId)

            val modernContemporaryHistoryQuestions = historyQuestions.generateModernContemporaryHistoryQuestions(modernContemporaryId)
            repo.addQuestionsToUnit(modernContemporaryHistoryQuestions, historyId, modernContemporaryId)


            // Biology -------------------------------------------------------------------------
            // 1. The Cell and its Functions
            val cellFunctionsUnit = SubjectUnit(name = "The Cell and its Functions", subjectId = bioId, id = "u1bio")
            val cellFunctionsId = repo.addUnitToSubject(cellFunctionsUnit, bioId)

            val cellFunctionsQuestions = bioQuestions.generateCellFunctionsQuestions(cellFunctionsId)
            repo.addQuestionsToUnit(cellFunctionsQuestions, bioId, cellFunctionsId)

            // 2. Human Body Systems
            val humanBodySystemsUnit = SubjectUnit(name = "Human Body Systems", subjectId = bioId, id = "u2bio")
            val humanBodySystemsId = repo.addUnitToSubject(humanBodySystemsUnit, bioId)

            val humanBodySystemsQuestions = bioQuestions.generateHumanBodySystemsQuestions(humanBodySystemsId)
            repo.addQuestionsToUnit(humanBodySystemsQuestions, bioId, humanBodySystemsId)

            // 3. Genetics and Evolution
            val geneticsEvolutionUnit = SubjectUnit(name = "Genetics and Evolution", subjectId = bioId, id = "u3bio")
            val geneticsEvolutionId = repo.addUnitToSubject(geneticsEvolutionUnit, bioId)

            val geneticsEvolutionQuestions = bioQuestions.generateGeneticsEvolutionQuestions(geneticsEvolutionId)
            repo.addQuestionsToUnit(geneticsEvolutionQuestions, bioId, geneticsEvolutionId)


            // Spanish -------------------------------------------------------------------------
            // 1. Grammar and Sentence Structure
            val grammarUnit = SubjectUnit(name = "Grammar and Sentence Structure", subjectId = spanishId, id = "u1spanish")
            val grammarId = repo.addUnitToSubject(grammarUnit, spanishId)

            val grammarQuestions = spanishQuestions.generateGrammarQuestions(grammarId)
            repo.addQuestionsToUnit(grammarQuestions, spanishId, grammarId)

            // 2. Literary Genres and Figures of Speech
            val literaryGenresUnit = SubjectUnit(name = "Literary Genres and Figures of Speech", subjectId = spanishId, id = "u2spanish")
            val literaryGenresId = repo.addUnitToSubject(literaryGenresUnit, spanishId)

            val literaryGenresQuestions = spanishQuestions.generateLiteraryGenresQuestions(literaryGenresId)
            repo.addQuestionsToUnit(literaryGenresQuestions, spanishId, literaryGenresId)


            // English -------------------------------------------------------------------------
            // 1. Grammar and Verb Tenses
            val englishGrammarUnit = SubjectUnit(name = "Grammar and Verb Tenses", subjectId = englishId, id = "u1english")
            val englishGrammarId = repo.addUnitToSubject(englishGrammarUnit, englishId)

            val englishGrammarQuestions = englishQuestions.generateEnglishGrammarQuestions(englishGrammarId)
            repo.addQuestionsToUnit(englishGrammarQuestions, englishId, englishGrammarId)

            // 2. Vocabulary and Everyday Expressions
            val englishVocabUnit = SubjectUnit(name = "Vocabulary and Everyday Expressions", subjectId = englishId, id = "u2english")
            val englishVocabId = repo.addUnitToSubject(englishVocabUnit, englishId)

            val englishVocabQuestions = englishQuestions.generateEnglishVocabQuestions(englishVocabId)
            repo.addQuestionsToUnit(englishVocabQuestions, englishId, englishVocabId)

            // DATABASE INITIALIZED --------------------------------
            repo.markDatabaseAsInitialized()
            _databaseInitialized.postValue(true)
        }
    }

    fun resetInitializationFlag() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.resetInitializationFlag()
            _databaseInitialized.postValue(false)
        }
    }
    private val mathQuestions = MathQuestions()
    private val scienceQuestions = ScienceQuestions()
    private val geoQuestions = GeographyQuestions()
    private val historyQuestions = HistoryQuestions()
    private val bioQuestions = BioQuestions()
    private val spanishQuestions = SpanishQuestions()
    private val englishQuestions = EnglishQuestions()

    // ── B. REAL-TIME LISTENERS ──────────────────────────────────────────────────
    private var subjectsReg: ListenerRegistration? = null
    private var unitsReg: ListenerRegistration?    = null
    private var questionsReg: ListenerRegistration? = null

    // LiveData directly from the repo
    val subjects: LiveData<List<Subject>> = repo.subjectsLiveData
    val units:    LiveData<List<SubjectUnit>> = repo.unitsLiveData
    // however for the questions we use the loads

    fun startListeningSubjects() {
        subjectsReg?.remove()
        subjectsReg = repo.listenToSubjects()
    }

    fun startListeningUnits(subjectId: String) {
        unitsReg?.remove()
        unitsReg = repo.listenToUnitsForSubject(subjectId)
    }

    fun startListeningQuestions(subjectId: String, unitId: String) {
        questionsReg?.remove()
        questionsReg = repo.listenToQuestionsForUnit(subjectId, unitId)
    }

    fun stopListeningAll() {
        subjectsReg?.remove()
        unitsReg?.remove()
        questionsReg?.remove()
    }

    private val _completedTests = MutableLiveData<Set<String>>(emptySet())
    val completedTests: LiveData<Set<String>> = _completedTests

    init {
        _databaseInitialized.value = false
         // Load completed tests from Firestore
        loadCompletedTests()
        
        // Check if we need to reset daily tests
        checkAndResetDailyTests()
    }

    // Load 5 questions for each test
    private val _randomQuestions = MutableLiveData<List<Question>>()
    val randomQuestions: LiveData<List<Question>> = _randomQuestions

    fun loadRandomQuestions(subjectId: String, unitId: String, count: Int = 5) {
        viewModelScope.launch(Dispatchers.IO) {
            val all = repo.getQuestionsForUnit(subjectId, unitId)
            _randomQuestions.postValue(all.shuffled().take(count))
        }
    }

    private fun checkAndResetDailyTests() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val lastResetDate = repo.getLastResetDate()
                val currentDate = LocalDate.now()
                
                if (lastResetDate == null || !lastResetDate.equals(currentDate)) {
                    // Reset completed tests for the new day
                    repo.resetCompletedTests()
                    _completedTests.postValue(emptySet())
                    // Update last reset date
                    repo.updateLastResetDate(currentDate)
                }
            } catch (e: Exception) {
                Log.e("RESET_TESTS", "Error checking/resetting daily tests", e)
            }
        }
    }

    private fun loadCompletedTests() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val completed = repo.getCompletedTests()
                _completedTests.postValue(completed)
            } catch (e: Exception) {
                Log.e("LOAD_COMPLETED", "Error loading completed tests", e)
            }
        }
    }


    fun markTestAsCompleted(subjectId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Update local state
                val currentCompleted = _completedTests.value ?: emptySet()
                _completedTests.postValue(currentCompleted + subjectId)

                // Persist to Firestore
                repo.markTestAsCompleted(subjectId)
            } catch (e: Exception) {
                Log.e("MARK_COMPLETED", "Error marking test as completed", e)
            }
        }
    }

    // ADD NEW SUBJECTS, UNITS OR QUESTIONS
    /** Creates a new subject */
    fun addSubject(name: String, customId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.addSubject(Subject(name), customId)
                // The subjects listener will automatically pick up this change
            } catch (e: Exception) {
                Log.e("DB_UPDATE", "Error adding subject", e)
            }
        }
    }

    /** Creates a new unit under an existing subject */
    fun addUnit(subjectId: String, unitName: String, unitCustomId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val unit = SubjectUnit(name = unitName, subjectId = subjectId, id = unitCustomId)
                repo.addUnitToSubject(unit, subjectId)
                // The units listener for this subject will pick up the new unit
            } catch (e: Exception) {
                Log.e("DB_UPDATE", "Error adding unit", e)
            }
        }
    }

    /** Adds a list of questions to a specific unit */
    fun addQuestions(subjectId: String, unitId: String, questions: List<Question>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.addQuestionsToUnit(questions, subjectId, unitId)

            } catch (e: Exception) {
                Log.e("DB_UPDATE", "Error adding questions", e)
            }
        }
    }

    // UPDATE DB WITHOUT INITIALIZING. ONLY IN DEBUG MODE
    fun seedGeoMapUnits() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // 1) Spanish Autonomous Communities Map
                val communitiesMapId = "u4geo"
                addUnit(
                    subjectId    = "geo",
                    unitName     = "Spanish Autonomous Communities Map",
                    unitCustomId = communitiesMapId
                )
                // Generate and add the community‐map questions
                val communitiesQs = geoQuestions.generateSpanishAutonomousCommunitiesMapQuestions(communitiesMapId)
                addQuestions(
                    subjectId = "geo",
                    unitId    = communitiesMapId,
                    questions = communitiesQs
                )

                // 2) Spanish Provinces Map
                val provincesMapId = "u5geo"
                addUnit(
                    subjectId    = "geo",
                    unitName     = "Spanish Provinces Map",
                    unitCustomId = provincesMapId
                )
                // Generate and add the province‐map questions
                val provincesQs = geoQuestions.generateSpanishProvincesMapQuestions(provincesMapId)
                addQuestions(
                    subjectId = "geo",
                    unitId    = provincesMapId,
                    questions = provincesQs
                )

                // 3) Europe Map
                val europeMapId = "u6geo"
                addUnit(
                    subjectId    = "geo",
                    unitName     = "Europe Map",
                    unitCustomId = europeMapId
                )
                // Generate and add the Europe‐map questions
                val europeQs = geoQuestions.generateEuropeMapQuestions(europeMapId)
                addQuestions(
                    subjectId = "geo",
                    unitId    = europeMapId,
                    questions = europeQs
                )

                Log.d("DB_SEED", "Map units and questions have been seeded successfully")
            } catch (e: Exception) {
                Log.e("DB_SEED", "Error while seeding geo map units", e)
            }
        }
    }
}
