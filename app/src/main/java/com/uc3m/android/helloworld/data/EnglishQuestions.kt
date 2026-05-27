package com.uc3m.android.helloworld.data

class EnglishQuestions {
    fun generateEnglishGrammarQuestions(englishGrammarId: String): List<Question> {
        return listOf(
            // TRUE_FALSE - EASY
            Question(
                questionText = "The present simple tense is used for actions that happen regularly or facts.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = englishGrammarId,
                id = "q1english1"
            ),
            Question(
                questionText = "The past simple tense is used for actions happening right now.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = englishGrammarId,
                id = "q2english1"
            ),

            // MULTIPLE_CHOICE - EASY
            Question(
                questionText = "Which of the following sentences is in the present continuous tense?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("I will go to the park.", "I am going to the park.", "I have gone to the park.", "I went to the park."),
                correctAnswer = "I am going to the park.",
                difficulty = Difficult.EASY,
                unitId = englishGrammarId,
                id = "q3english1"
            ),
            Question(
                questionText = "Which sentence is in the future simple tense?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("I am working today.", "I will work tomorrow.", "I have worked today.", "I was working yesterday."),
                correctAnswer = "I will work tomorrow.",
                difficulty = Difficult.EASY,
                unitId = englishGrammarId,
                id = "q4english1"
            ),

            // SHORT_ANSWER - EASY
            Question(
                questionText = "What is the past form of 'go'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "went",
                difficulty = Difficult.EASY,
                unitId = englishGrammarId,
                id = "q5english1"
            ),
            Question(
                questionText = "What auxiliary verb is used with 'I' to form questions in the present simple?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "do",
                difficulty = Difficult.EASY,
                unitId = englishGrammarId,
                id = "q6english1"
            ),

            // MULTIPLE_CHOICE - MEDIUM
            Question(
                questionText = "Which of the following sentences is in the past perfect tense?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("She has eaten dinner.", "She ate dinner.", "She had eaten dinner.", "She will eat dinner."),
                correctAnswer = "She had eaten dinner.",
                difficulty = Difficult.MEDIUM,
                unitId = englishGrammarId,
                id = "q8english1"
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                questionText = "The future continuous tense is used for actions that will be happening at a specific time in the future.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = englishGrammarId,
                id = "q9english1"
            ),

            // SHORT_ANSWER - MEDIUM
            Question(
                questionText = "What is the auxiliary verb used in the question form of the present continuous tense?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "am",
                difficulty = Difficult.MEDIUM,
                unitId = englishGrammarId,
                id = "q10english1"
            ),

            // MULTIPLE_CHOICE - HARD
            Question(
                questionText = "Which of the following is the correct form of the verb in the first conditional?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("If I will go to the park, I will see her.", "If I go to the park, I will see her.", "If I go to the park, I would see her.", "If I went to the park, I will see her."),
                correctAnswer = "If I go to the park, I will see her.",
                difficulty = Difficult.HARD,
                unitId = englishGrammarId,
                id = "q12english1"
            ),

            // TRUE_FALSE - HARD
            Question(
                questionText = "The present perfect continuous tense is used for actions that started in the past and are still continuing or have recently finished.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = englishGrammarId,
                id = "q13english1"
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "What is the correct form of 'to be' for 'they' in the future continuous tense?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "will be",
                difficulty = Difficult.HARD,
                unitId = englishGrammarId,
                id = "q14english1"
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "What is the auxiliary verb used to form the past perfect tense?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "had",
                difficulty = Difficult.HARD,
                unitId = englishGrammarId,
                id = "q15english1"
            )
        )
    }

    fun generateEnglishVocabQuestions(englishVocabId: String): List<Question> {
        return listOf(
            // TRUE_FALSE - EASY
            Question(
                questionText = "The word 'appreciate' means to express gratitude or thanks.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                id = "q1english2",
                unitId = englishVocabId
            ),
            Question(
                questionText = "The word 'seldom' means 'always'.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                id = "q2english2",
                unitId = englishVocabId
            ),

            // MULTIPLE_CHOICE - EASY
            Question(
                questionText = "Which of the following is a synonym for 'happy'?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("angry", "joyful", "sad", "frightened"),
                correctAnswer = "joyful",
                difficulty = Difficult.EASY,
                id = "q3english2",
                unitId = englishVocabId
            ),
            Question(
                questionText = "Which of the following words is an expression used to greet someone?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("How are you?", "Good night!", "See you later.", "Thank you."),
                correctAnswer = "How are you?",
                difficulty = Difficult.EASY,
                id = "q4english2",
                unitId = englishVocabId
            ),

            // SHORT_ANSWER - EASY
            Question(
                questionText = "What is the opposite of 'hot'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "cold",
                difficulty = Difficult.EASY,
                id = "q5english2",
                unitId = englishVocabId
            ),
            Question(
                questionText = "What does 'thank you' mean?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "an expression of gratitude",
                difficulty = Difficult.EASY,
                id = "q6english2",
                unitId = englishVocabId
            ),


            // MULTIPLE_CHOICE - MEDIUM
            Question(
                questionText = "Which of the following expressions is used to express gratitude?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Sorry to hear that.", "Thank you.", "Nice to meet you.", "Good luck."),
                correctAnswer = "Thank you.",
                difficulty = Difficult.MEDIUM,
                id = "q8english2",
                unitId = englishVocabId
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                questionText = "'Goodbye' is a formal way of saying 'hello'.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                id = "q9english2",
                unitId = englishVocabId
            ),

            // SHORT_ANSWER - MEDIUM
            Question(
                questionText = "What does the expression 'to catch up' mean?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "to talk to someone after a period of not speaking",
                difficulty = Difficult.MEDIUM,
                id = "q10english2",
                unitId = englishVocabId
            ),


            // MULTIPLE_CHOICE - HARD
            Question(
                questionText = "Which of the following is an idiomatic expression meaning 'to succeed'?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("break a leg", "hit the nail on the head", "call it a day", "under the weather"),
                correctAnswer = "break a leg",
                difficulty = Difficult.HARD,
                id = "q12english2",
                unitId = englishVocabId
            ),

            // TRUE_FALSE - HARD
            Question(
                questionText = "'A piece of cake' means something very difficult.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                id = "q13english2",
                unitId = englishVocabId
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "What is the meaning of the phrase 'to pull someone's leg'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "to joke or tease someone",
                difficulty = Difficult.HARD,
                id = "q14english2",
                unitId = englishVocabId
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "What does the expression 'in the nick of time' mean?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "just in time; at the last possible moment",
                difficulty = Difficult.HARD,
                id = "q15english2",
                unitId = englishVocabId
            )
        )
    }

}