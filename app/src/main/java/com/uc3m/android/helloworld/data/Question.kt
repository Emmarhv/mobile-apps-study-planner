package com.uc3m.android.helloworld.data

data class Question(
    val questionText: String ="", // The text of the question
    val type: QuestionType = QuestionType.TRUE_FALSE, // Type of question (enum: TrueFalse, MultipleChoice, ShortAnswer)
    val options: List<String>? = null, // Options only applicable for "MultipleChoice"
    var correctAnswer: Any? = null, // Correct answer. It can be a Boolean, String, Map, etc.
    val difficulty: Difficult = Difficult.EASY, // "easy" or "hard"
    val unitId: String = "", // The ID of the unit to which this question belongs
    val id: String? = null, // The ID of the question in the database
    // MAP questions
    val geoJsonAsset: String? = null,        // name of the map that need to be used
    val regionProperty: String? = null      // each feature of the map
)

// Defining question types as an enum for better management
enum class QuestionType {
    TRUE_FALSE,
    MULTIPLE_CHOICE,
    SHORT_ANSWER,
    MAP
}

enum class Difficult {
    HARD,
    EASY,
    MEDIUM
}
