package com.uc3m.android.helloworld.data

class HistoryQuestions {
    fun generateAncientHistoryQuestions(ancientHistoryId: String): List<Question> {
        return listOf(
            // TRUE_FALSE - EASY
            Question(
                id = "q1history1",
                questionText = "The Roman Empire came after Ancient Greece.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = ancientHistoryId
            ),
            Question(
                id = "q2history1",
                questionText = "The Stone Age was a period in which humans used advanced metal tools.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = ancientHistoryId
            ),

            // MULTIPLE_CHOICE - EASY
            Question(
                id = "q3history1",
                questionText = "Which of these was a major city in Ancient Greece?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Rome", "Carthage", "Athens", "Alexandria"),
                correctAnswer = "Athens",
                difficulty = Difficult.EASY,
                unitId = ancientHistoryId
            ),
            Question(
                id = "q4history1",
                questionText = "What form of government did Athens develop?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Monarchy", "Dictatorship", "Democracy", "Oligarchy"),
                correctAnswer = "Democracy",
                difficulty = Difficult.EASY,
                unitId = ancientHistoryId
            ),

            // SHORT_ANSWER - EASY
            Question(
                id = "q5history1",
                questionText = "What was the name of the Roman arena used for gladiator fights?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "colosseum",
                difficulty = Difficult.EASY,
                unitId = ancientHistoryId
            ),
            Question(
                id = "q6history1",
                questionText = "Who was the king of the Greek gods?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "zeus",
                difficulty = Difficult.EASY,
                unitId = ancientHistoryId
            ),

            // MULTIPLE_CHOICE - MEDIUM
            Question(
                id = "q8history1",
                questionText = "Who was Julius Caesar?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Greek philosopher", "Egyptian pharaoh", "Roman general", "Byzantine emperor"),
                correctAnswer = "Roman general",
                difficulty = Difficult.MEDIUM,
                unitId = ancientHistoryId
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                id = "q9history1",
                questionText = "Prehistoric humans lived in organized cities.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                unitId = ancientHistoryId
            ),

            // SHORT_ANSWER - MEDIUM
            Question(
                id = "q10history1",
                questionText = "What writing system did the Ancient Romans use?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "latin",
                difficulty = Difficult.MEDIUM,
                unitId = ancientHistoryId
            ),


            // MULTIPLE_CHOICE - HARD
            Question(
                id = "q12history1",
                questionText = "What event traditionally marks the end of Ancient Rome?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("The death of Julius Caesar", "The fall of Constantinople", "The founding of the Republic", "The fall of the Western Roman Empire"),
                correctAnswer = "The fall of the Western Roman Empire",
                difficulty = Difficult.HARD,
                unitId = ancientHistoryId
            ),

            // TRUE_FALSE - HARD
            Question(
                id = "q13history1",
                questionText = "Homer was a famous Roman historian.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = ancientHistoryId
            ),

            // SHORT_ANSWER - HARD
            Question(
                id = "q14history1",
                questionText = "Which war was fought between Athens and Sparta?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "peloponnesian war",
                difficulty = Difficult.HARD,
                unitId = ancientHistoryId
            ),
            Question(
                id = "q15history1",
                questionText = "Who was the philosopher who taught Alexander the Great?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "aristotle",
                difficulty = Difficult.HARD,
                unitId = ancientHistoryId
            )
        )
    }

    fun generateMedievalRenaissanceQuestions(medievalRenaissanceId: String): List<Question> {
        return listOf(
            // TRUE_FALSE - EASY
            Question(
                id = "q1history2",
                questionText = "The Middle Ages ended with the start of the Modern Age.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = medievalRenaissanceId
            ),
            Question(
                id = "q2history2",
                questionText = "The Renaissance occurred during the Middle Ages.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = medievalRenaissanceId
            ),

            // MULTIPLE_CHOICE - EASY
            Question(
                id = "q3history2",
                questionText = "Who was a famous painter and scientist of the Renaissance?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Leonardo da Vinci", "Napoleon Bonaparte", "Albert Einstein", "William Shakespeare"),
                correctAnswer = "Leonardo da Vinci",
                difficulty = Difficult.EASY,
                unitId = medievalRenaissanceId
            ),
            Question(
                id = "q4history2",
                questionText = "In which city did the Renaissance begin?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Rome", "Florence", "London", "Madrid"),
                correctAnswer = "Florence",
                difficulty = Difficult.EASY,
                unitId = medievalRenaissanceId
            ),

            // SHORT_ANSWER - EASY
            Question(
                id = "q5history2",
                questionText = "What is the name of Leonardo da Vinci's famous painting that shows a woman smiling?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Mona Lisa",
                difficulty = Difficult.EASY,
                unitId = medievalRenaissanceId
            ),
            Question(
                id = "q6history2",
                questionText = "Who is the author of 'Don Quixote'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Miguel de Cervantes",
                difficulty = Difficult.EASY,
                unitId = medievalRenaissanceId
            ),

            // MULTIPLE_CHOICE - MEDIUM
            Question(
                id = "q8history2",
                questionText = "What event marked the beginning of the Modern Age?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("The fall of Rome", "The fall of Constantinople", "The French Revolution", "The discovery of America"),
                correctAnswer = "The fall of Constantinople",
                difficulty = Difficult.MEDIUM,
                unitId = medievalRenaissanceId
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                id = "q9history2",
                questionText = "The painting 'The Last Supper' was made by Leonardo da Vinci.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = medievalRenaissanceId
            ),

            // SHORT_ANSWER - MEDIUM
            Question(
                id = "q10history2",
                questionText = "Which Renaissance inventor developed the concept of 'perspective' in painting?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Brunelleschi",
                difficulty = Difficult.MEDIUM,
                unitId = medievalRenaissanceId
            ),

            // MULTIPLE_CHOICE - HARD
            Question(
                id = "q12history2",
                questionText = "Who was the author of 'The Prince', a work that influenced Renaissance politics?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Niccolò Machiavelli", "Galileo Galilei", "Thomas More", "Martin Luther"),
                correctAnswer = "Niccolò Machiavelli",
                difficulty = Difficult.HARD,
                unitId = medievalRenaissanceId
            ),

            // TRUE_FALSE - HARD
            Question(
                id = "q13history2",
                questionText = "The Renaissance was a period focused on the recovery of ideals from ancient Rome and Greece.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = medievalRenaissanceId
            ),

            // SHORT_ANSWER - HARD
            Question(
                id = "q14history2",
                questionText = "Which famous Renaissance philosopher wrote the book 'Utopia'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Thomas More",
                difficulty = Difficult.HARD,
                unitId = medievalRenaissanceId
            ),

            // SHORT_ANSWER - HARD
            Question(
                id = "q15history2",
                questionText = "What is the name of the painter who created the fresco 'The School of Athens'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Raphael",
                difficulty = Difficult.HARD,
                unitId = medievalRenaissanceId
            )
        )
    }

    fun generateModernContemporaryHistoryQuestions(modernContemporaryId: String): List<Question> {
        return listOf(
            // TRUE_FALSE - EASY
            Question(
                id = "q1history3",
                questionText = "The Industrial Revolution began in the United States.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = modernContemporaryId
            ),
            Question(
                id = "q2history3",
                questionText = "The World War I ended in 1918.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = modernContemporaryId
            ),

            // MULTIPLE_CHOICE - EASY
            Question(
                id = "q3history3",
                questionText = "Who was the leader of the Soviet Union during World War II?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Joseph Stalin", "Vladimir Lenin", "Leon Trotsky", "Mikhail Gorbachev"),
                correctAnswer = "Joseph Stalin",
                difficulty = Difficult.EASY,
                unitId = modernContemporaryId
            ),
            Question(
                id = "q4history3",
                questionText = "Which event started World War II?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("The invasion of Poland", "The attack on Pearl Harbor", "The signing of the Versailles Treaty", "The Russian Revolution"),
                correctAnswer = "The invasion of Poland",
                difficulty = Difficult.EASY,
                unitId = modernContemporaryId
            ),

            // SHORT_ANSWER - EASY
            Question(
                id = "q5history3",
                questionText = "Who was the first president of the United States?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "George Washington",
                difficulty = Difficult.EASY,
                unitId = modernContemporaryId
            ),
            Question(
                id = "q6history3",
                questionText = "In what year did the Berlin Wall fall?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "1989",
                difficulty = Difficult.EASY,
                unitId = modernContemporaryId
            ),

            // MULTIPLE_CHOICE - MEDIUM
            Question(
                id = "q8history3",
                questionText = "Which treaty ended World War I?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Treaty of Versailles", "Treaty of Paris", "Treaty of Tordesillas", "Treaty of Ghent"),
                correctAnswer = "Treaty of Versailles",
                difficulty = Difficult.MEDIUM,
                unitId = modernContemporaryId
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                id = "q9history3",
                questionText = "The United States joined World War I in 1917.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = modernContemporaryId
            ),

            // SHORT_ANSWER - MEDIUM
            Question(
                id = "q10history3",
                questionText = "What was the name of the first artificial satellite launched by the Soviet Union in 1957?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Sputnik 1",
                difficulty = Difficult.MEDIUM,
                unitId = modernContemporaryId
            ),


            // MULTIPLE_CHOICE - HARD
            Question(
                id = "q12history3",
                questionText = "Which of the following was NOT a factor in the outbreak of World War I?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Nationalism", "Imperialism", "The Great Depression", "Militarism"),
                correctAnswer = "The Great Depression",
                difficulty = Difficult.HARD,
                unitId = modernContemporaryId
            ),

            // TRUE_FALSE - HARD
            Question(
                id = "q13history3",
                questionText = "The Cold War was primarily a conflict between the United States and the Soviet Union.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = modernContemporaryId
            ),

            // SHORT_ANSWER - HARD
            Question(
                id = "q14history3",
                questionText = "Who was the leader of the Nazi party in Germany?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Adolf Hitler",
                difficulty = Difficult.HARD,
                unitId = modernContemporaryId
            ),
            Question(
                id = "q15history3",
                questionText = "Which event triggered the start of World War II in the Pacific?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Attack on Pearl Harbor",
                difficulty = Difficult.HARD,
                unitId = modernContemporaryId
            )
        )
    }


}