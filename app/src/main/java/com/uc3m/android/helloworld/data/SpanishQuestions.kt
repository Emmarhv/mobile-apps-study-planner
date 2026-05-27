package com.uc3m.android.helloworld.data

class SpanishQuestions {
    fun generateGrammarQuestions(grammarId: String): List<Question> {
        return listOf(
            // TRUE_FALSE - EASY
            Question(
                questionText = "En la oración 'María come una manzana', el sujeto es 'María'.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = grammarId,
                id = "q1spanish1"
            ),
            Question(
                questionText = "El verbo en la oración 'Nosotros comemos pan' está en presente de indicativo.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = grammarId,
                id = "q2spanish1"
            ),

            // MULTIPLE_CHOICE - EASY
            Question(
                questionText = "¿Cuál de las siguientes oraciones está correctamente conjugada?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Yo hablé con él", "Yo hablo con él", "Yo hablaba con él", "Yo hablaré con él"),
                correctAnswer = "Yo hablo con él",
                difficulty = Difficult.EASY,
                unitId = grammarId,
                id = "q3spanish1"
            ),
            Question(
                questionText = "¿Cuál de las siguientes palabras es un adverbio?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Feliz", "Corriendo", "Rápidamente", "Libro"),
                correctAnswer = "Rápidamente",
                difficulty = Difficult.EASY,
                unitId = grammarId,
                id = "q4spanish1"
            ),

            // SHORT_ANSWER - EASY
            Question(
                questionText = "¿Qué tipo de pronombre es la palabra 'ellos' en la oración 'Ellos van al cine'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Pronombre personal",
                difficulty = Difficult.EASY,
                unitId = grammarId,
                id = "q5spanish1"
            ),
            Question(
                questionText = "¿Cómo se llama la acción del verbo en la oración 'Juan canta una canción'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Verbo transitivo",
                difficulty = Difficult.EASY,
                unitId = grammarId,
                id = "q6spanish1"
            ),


            // MULTIPLE_CHOICE - MEDIUM
            Question(
                questionText = "¿Cuál de las siguientes oraciones tiene un complemento directo?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Juan corre en el parque", "María come una pizza", "Ellos estudian mucho", "Nosotros viajamos a Madrid"),
                correctAnswer = "María come una pizza",
                difficulty = Difficult.MEDIUM,
                unitId = grammarId,
                id = "q8spanish1"
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                questionText = "En una oración subordinada, el verbo de la oración subordinada está en modo subjuntivo.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = grammarId,
                id = "q9spanish1"
            ),

            // SHORT_ANSWER - MEDIUM
            Question(
                questionText = "¿Cómo se llama el tipo de oración que expresa una acción realizada por el sujeto, como 'El perro corre'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Oración enunciativa",
                difficulty = Difficult.MEDIUM,
                unitId = grammarId,
                id = "q10spanish1"
            ),


            // MULTIPLE_CHOICE - HARD
            Question(
                questionText = "¿Cuál de las siguientes oraciones contiene un pronombre de objeto directo?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Le di el libro a Juan", "Vi a María en el parque", "Nosotros fuimos a la tienda", "Él me habló"),
                correctAnswer = "Vi a María en el parque",
                difficulty = Difficult.HARD,
                unitId = grammarId,
                id = "q12spanish1"
            ),

            // TRUE_FALSE - HARD
            Question(
                questionText = "La oración 'Quiero que tú estudies' es una oración subordinada adverbial.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = grammarId,
                id = "q13spanish1"
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "En la oración 'Aunque llueva, iremos al cine', ¿qué tipo de conjunción se utiliza?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Conjunción subordinante",
                difficulty = Difficult.HARD,
                unitId = grammarId,
                id = "q14spanish1"
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "¿Qué tipo de oración es 'Si tú hablas, ellos escuchan'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Oración condicional",
                difficulty = Difficult.HARD,
                unitId = grammarId,
                id = "q15spanish1"
            )
        )
    }

    fun generateLiteraryGenresQuestions(literaryGenresId: String): List<Question> {
        return listOf(
            // TRUE_FALSE - EASY
            Question(
                questionText = "El género lírico se caracteriza por expresar los sentimientos del autor.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = literaryGenresId,
                id = "q1spanish2"
            ),
            Question(
                questionText = "El género narrativo incluye obras como novelas y cuentos.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = literaryGenresId,
                id = "q2spanish2"
            ),

            // MULTIPLE_CHOICE - EASY
            Question(
                questionText = "¿Cuál de los siguientes ejemplos corresponde al género dramático?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Cuento", "Poema", "Obra de teatro", "Novela"),
                correctAnswer = "Obra de teatro",
                difficulty = Difficult.EASY,
                unitId = literaryGenresId,
                id = "q3spanish2"
            ),
            Question(
                questionText = "¿Qué figura literaria consiste en atribuir cualidades humanas a objetos o animales?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Metáfora", "Personificación", "Hipérbole", "Antítesis"),
                correctAnswer = "Personificación",
                difficulty = Difficult.EASY,
                unitId = literaryGenresId,
                id = "q4spanish2"
            ),

            // SHORT_ANSWER - EASY
            Question(
                questionText = "¿Cómo se llama el tipo de figura literaria en la que se repiten sonidos consonantes de forma intencionada?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Aliteración",
                difficulty = Difficult.EASY,
                unitId = literaryGenresId,
                id = "q5spanish2"
            ),
            Question(
                questionText = "¿Qué género literario incluye los poemas y canciones?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Género lírico",
                difficulty = Difficult.EASY,
                unitId = literaryGenresId,
                id = "q6spanish2"
            ),


            // MULTIPLE_CHOICE - MEDIUM
            Question(
                questionText = "¿Cuál de los siguientes ejemplos es una metáfora?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("El sol brilla como oro", "La luna es un espejo", "El río es un serpentín de plata", "El árbol de la vida"),
                correctAnswer = "El río es un serpentín de plata",
                difficulty = Difficult.MEDIUM,
                unitId = literaryGenresId,
                id = "q8spanish2"
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                questionText = "Una hipérbole es una exageración de la realidad con fines expresivos.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = literaryGenresId,
                id = "q9spanish2"
            ),

            // SHORT_ANSWER - MEDIUM
            Question(
                questionText = "¿Cómo se llama la figura literaria que consiste en la repetición de una palabra al final de las oraciones?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Epítesis",
                difficulty = Difficult.MEDIUM,
                unitId = literaryGenresId,
                id = "q10spanish2"
            ),

            // MULTIPLE_CHOICE - HARD
            Question(
                questionText = "¿Cuál de las siguientes es una característica del género narrativo?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("El uso de diálogos", "El ritmo pausado y reflexivo", "La expresión de sentimientos profundos", "La representación de una obra en el escenario"),
                correctAnswer = "El uso de diálogos",
                difficulty = Difficult.HARD,
                unitId = literaryGenresId,
                id = "q12spanish2"
            ),

            // TRUE_FALSE - HARD
            Question(
                questionText = "El género dramático se limita a las obras de teatro y no puede incluir otros tipos de expresión como el cine.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = literaryGenresId,
                id = "q13spanish2"
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "¿Qué figura literaria se utiliza cuando se dice 'La ciudad despertó con el sol'?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Personificación",
                difficulty = Difficult.HARD,
                unitId = literaryGenresId,
                id = "q14spanish2"
            ),

            // SHORT_ANSWER - HARD
            Question(
                questionText = "¿Cómo se llama la figura literaria en la que se exagera la realidad para dar énfasis?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Hipérbole",
                difficulty = Difficult.HARD,
                unitId = literaryGenresId,
                id = "q15spanish2"
            )
        )
    }


}