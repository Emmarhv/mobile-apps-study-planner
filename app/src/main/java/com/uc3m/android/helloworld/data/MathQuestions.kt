package com.uc3m.android.helloworld.data

class MathQuestions {
    fun generateAlgebraQuestions(algebraId: String): List<Question> {
        return listOf(
            Question(
                id = "q1maths1",
                questionText = "What are the solutions to the equation x² - 5x + 6 = 0?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("x = 2 and x = 3", "x = -2 and x = -3", "x = 1 and x = 6"),
                correctAnswer = "x = 2 and x = 3",
                difficulty = Difficult.HARD,
                unitId = algebraId
            ),
            Question(
                id = "q2maths1",
                questionText = "Which expression is equivalent to x² + 6x + 9?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("(x + 3)²", "(x + 9)²", "(x + 6)²"),
                correctAnswer = "(x + 3)²",
                difficulty = Difficult.HARD,
                unitId = algebraId
            ),
            Question(
                id = "q3maths1",
                questionText = "Which of the following is the result of simplifying (2x - 3)(x + 4)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("2x² + 5x - 12", "2x² + 8x - 3", "2x² + 5x - 12"),
                correctAnswer = "2x² + 5x - 12",
                difficulty = Difficult.EASY,
                unitId = algebraId
            ),
            Question(
                id = "q4maths1",
                questionText = "The expression √(x²) is equal to x for all real values of x.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = algebraId
            ),
            Question(
                id = "q5maths1",
                questionText = "The identity (a - b)² = a² - 2ab + b² is always true.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = algebraId
            ),
            Question(
                id = "q6maths1",
                questionText = "Solve the equation: 3x² - 12x = 0",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 0 or x = 4",
                difficulty = Difficult.MEDIUM,
                unitId = algebraId
            ),
            Question(
                id = "q7maths1",
                questionText = "Factor completely: x² - 2x - 8",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "(x - 4)(x + 2)",
                difficulty = Difficult.HARD,
                unitId = algebraId
            ),
            Question(
                id = "q8maths1",
                questionText = "What is the value of x in the equation 2(x - 3) = x + 1?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 7",
                difficulty = Difficult.MEDIUM,
                unitId = algebraId
            ),

            Question(
                id = "q11maths1",
                questionText = "What is the result of simplifying (x - 2)(x + 3)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("x² + x - 6", "x² + x + 6", "x² - x - 6"),
                correctAnswer = "x² + x - 6",
                difficulty = Difficult.EASY,
                unitId = algebraId
            ),
            Question(
                id = "q12maths1",
                questionText = "Which of the following is the factored form of x² + 5x + 6?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("(x + 2)(x + 3)", "(x + 1)(x + 6)", "(x - 1)(x - 6)"),
                correctAnswer = "(x + 2)(x + 3)",
                difficulty = Difficult.MEDIUM,
                unitId = algebraId
            ),
            Question(
                id = "q13maths1",
                questionText = "Simplify: (3x - 4)²",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "9x² - 24x + 16",
                difficulty = Difficult.HARD,
                unitId = algebraId
            ),
            Question(
                id = "q14maths1",
                questionText = "Which is the solution to the equation 4x + 8 = 20?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 3",
                difficulty = Difficult.EASY,
                unitId = algebraId
            ),
            Question(
                id = "q15maths1",
                questionText = "The equation x² - 9 = 0 has more than one solution?",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = algebraId
            )
        )
    }


    fun generateGeometryQuestions(geometryId: String): List<Question> {
        return listOf(
            Question(
                id = "q1maths2",
                questionText = "What is the sum of the interior angles of a triangle?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("180°", "360°", "90°"),
                correctAnswer = "180°",
                difficulty = Difficult.EASY,
                unitId = geometryId
            ),
            Question(
                id = "q2maths2",
                questionText = "What is the area of a circle with radius 5 cm?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("25π cm²", "10π cm²", "5π cm²"),
                correctAnswer = "25π cm²",
                difficulty = Difficult.MEDIUM,
                unitId = geometryId
            ),
            Question(
                id = "q3maths2",
                questionText = "The sum of the exterior angles of any polygon is 180°.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = geometryId
            ),
            Question(
                id = "q4maths2",
                questionText = "The opposite sides of a parallelogram are equal and parallel.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = geometryId
            ),
            Question(
                id = "q5maths2",
                questionText = "Solve for the area of a trapezoid with bases 6 cm and 8 cm, and height 4 cm. (in cm²)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "28",
                difficulty = Difficult.HARD,
                unitId = geometryId
            ),
            Question(
                id = "q6maths2",
                questionText = "Find the length of the hypotenuse of a right triangle with legs of length 3 cm and 4 cm. (in cm)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "5",
                difficulty = Difficult.MEDIUM,
                unitId = geometryId
            ),
            Question(
                id = "q7maths2",
                questionText = "What is the volume of a cylinder with radius 3 cm and height 10 cm?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("90π cm³", "30π cm³", "60π cm³"),
                correctAnswer = "90π cm³",
                difficulty = Difficult.HARD,
                unitId = geometryId
            ),

            Question(
                id = "q10maths2",
                questionText = "What is the surface area of a cube with side length 4 cm?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("96 cm²", "64 cm²", "48 cm²"),
                correctAnswer = "96 cm²",
                difficulty = Difficult.MEDIUM,
                unitId = geometryId
            ),
            Question(
                id = "q11maths2",
                questionText = "What is the perimeter of a rectangle with length 5 cm and width 3 cm? (in cm)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "16",
                difficulty = Difficult.EASY,
                unitId = geometryId
            ),
            Question(
                id = "q12maths2",
                questionText = "Find the area of a triangle with base 10 cm and height 6 cm (in cm²)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "30",
                difficulty = Difficult.MEDIUM,
                unitId = geometryId
            ),
            Question(
                id = "q13maths2",
                questionText = "The diagonals of a rhombus are perpendicular and bisect each other at right angles.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = geometryId
            ),
            Question(
                id = "q14maths2",
                questionText = "What is the measure of each interior angle of a regular polygon with 8 sides?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("135°", "120°", "108°"),
                correctAnswer = "135°",
                difficulty = Difficult.HARD,
                unitId = geometryId
            )
        )
    }

    fun generateFunctionsQuestions(functionsId: String): List<Question> {
        return listOf(
            Question(
                id = "q1maths6",
                questionText = "What is the domain of the function f(x) = √(x - 2)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("x ≥ 2", "x > 2", "x ≤ 2"),
                correctAnswer = "x ≥ 2",
                difficulty = Difficult.EASY,
                unitId = functionsId
            ),
            Question(
                id = "q2maths6",
                questionText = "Which of the following represents the function y = x² - 3x + 2 in vertex form?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("y = (x - 1.5)² - 0.25", "y = (x - 1)² - 1", "y = (x - 1)² + 1"),
                correctAnswer = "y = (x - 1)² - 1",
                difficulty = Difficult.MEDIUM,
                unitId = functionsId
            ),
            Question(
                id = "q3maths6",
                questionText = "The graph of the function f(x) = x³ is an odd function.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = functionsId
            ),
            Question(
                id = "q4maths6",
                questionText = "The function f(x) = 2x + 1 is a quadratic function.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                unitId = functionsId
            ),
            Question(
                id = "q5maths6",
                questionText = "Find the inverse of the function f(x) = 3x + 4.",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "f⁻¹(x) = (x - 4) / 3",
                difficulty = Difficult.HARD,
                unitId = functionsId
            ),
            Question(
                id = "q6maths6",
                questionText = "Solve for f(2) if f(x) = 2x - 3.",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "f(2) = 1",
                difficulty = Difficult.MEDIUM,
                unitId = functionsId
            ),
            Question(
                id = "q7maths6",
                questionText = "Which of the following is the correct expression for the composition of functions (f ∘ g)(x) if f(x) = 2x + 1 and g(x) = x²?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("2x² + 1", "2x² + 2x + 1", "2x² + 1 + x"),
                correctAnswer = "2x² + 1",
                difficulty = Difficult.HARD,
                unitId = functionsId
            ),

            Question(
                id = "q10maths6",
                questionText = "What is the range of the function f(x) = 1 / x?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("All real numbers except 0", "x > 0", "x < 0"),
                correctAnswer = "All real numbers except 0",
                difficulty = Difficult.MEDIUM,
                unitId = functionsId
            ),
            Question(
                id = "q11maths6",
                questionText = "What is the slope of the line defined by f(x) = 5x - 3?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "5",
                difficulty = Difficult.EASY,
                unitId = functionsId
            ),
            Question(
                id = "q12maths6",
                questionText = "Find the x-intercept of the function f(x) = 2x - 4.",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 2",
                difficulty = Difficult.MEDIUM,
                unitId = functionsId
            ),
            Question(
                id = "q13maths6",
                questionText = "The function f(x) = |x - 1| is continuous but not differentiable at x = 1.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = functionsId
            ),
            Question(
                id = "q14maths6",
                questionText = "What is the domain of the function f(x) = 1 / (x² - 4)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("x ≠ 2, x ≠ -2", "x > 2", "x ≠ 0"),
                correctAnswer = "x ≠ 2, x ≠ -2",
                difficulty = Difficult.HARD,
                unitId = functionsId
            )
        )
    }


    fun generateStatsQuestions(statsId: String): List<Question> {
        return listOf(
            Question(
                id = "q1maths3",
                questionText = "What is the mean of the following set of numbers: 2, 4, 6, 8, 10?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("6", "5", "7"),
                correctAnswer = "6",
                difficulty = Difficult.EASY,
                unitId = statsId
            ),
            Question(
                id = "q2maths3",
                questionText = "In a deck of 52 playing cards, what is the probability of drawing a king?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("1/13", "1/52", "1/26"),
                correctAnswer = "1/13",
                difficulty = Difficult.MEDIUM,
                unitId = statsId
            ),
            Question(
                id = "q3maths3",
                questionText = "The mean is always equal to the median in a normal distribution.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = statsId
            ),
            Question(
                id = "q4maths3",
                questionText = "The variance of a set of numbers can never be negative.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = statsId
            ),
            Question(
                id = "q5maths3",
                questionText = "What is the mode of the set: 3, 7, 3, 9, 3?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "3",
                difficulty = Difficult.EASY,
                unitId = statsId
            ),
            Question(
                id = "q6maths3",
                questionText = "Find the median of the following set: 5, 3, 8, 1, 6.",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "5",
                difficulty = Difficult.MEDIUM,
                unitId = statsId
            ),
            Question(
                id = "q7maths3",
                questionText = "What is the probability of rolling a sum of 7 on two six-sided dice?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("1/6", "1/36", "5/36"),
                correctAnswer = "1/6",
                difficulty = Difficult.HARD,
                unitId = statsId
            ),

            Question(
                id = "q9maths3",
                questionText = "What is the probability of drawing a red card from a deck of 52 cards?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("1/2", "1/4", "1/52"),
                correctAnswer = "1/2",
                difficulty = Difficult.MEDIUM,
                unitId = statsId
            ),
            Question(
                id = "q10maths3",
                questionText = "What is the probability of drawing a queen or a king from a deck of 52 cards?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "8",
                difficulty = Difficult.HARD,
                unitId = statsId
            ),
            Question(
                id = "q11maths3",
                questionText = "What is the variance of the set: 2, 4, 6, 8?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "5",
                difficulty = Difficult.MEDIUM,
                unitId = statsId
            ),
            Question(
                id = "q12maths3",
                questionText = "In a standard normal distribution, the probability of a value being greater than 1 standard deviation above the mean is 0.1587.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = statsId
            ),
            Question(
                id = "q13maths3",
                questionText = "In a normal distribution, what percentage of data falls within one standard deviation of the mean?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("68%", "95%", "99%"),
                correctAnswer = "68%",
                difficulty = Difficult.HARD,
                unitId = statsId
            ),
            Question(
                id = "q14maths3",
                questionText = "What is the range of the set: 1, 5, 7, 9, 3?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "8",
                difficulty = Difficult.MEDIUM,
                unitId = statsId
            ),
            Question(
                id = "q15maths3",
                questionText = "What is the z-score for a value of 45 in a distribution with a mean of 40 and a standard deviation of 5?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "1",
                difficulty = Difficult.HARD,
                unitId = statsId
            ),
        )
    }

    fun generateTrigQuestions(trigId: String): List<Question> {
        return listOf(
            Question(
                id = "q1maths4",
                questionText = "What is the value of sin(30°)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("1/2", "√3/2", "1"),
                correctAnswer = "1/2",
                difficulty = Difficult.EASY,
                unitId = trigId
            ),
            Question(
                id = "q2maths4",
                questionText = "What is the value of cos(90°)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("0", "1", "√2/2"),
                correctAnswer = "0",
                difficulty = Difficult.MEDIUM,
                unitId = trigId
            ),
            Question(
                id = "q3maths4",
                questionText = "The sine of 45° is equal to √2/2.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = trigId
            ),
            Question(
                id = "q4maths4",
                questionText = "The tangent of 0° is equal to 1.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                unitId = trigId
            ),
            Question(
                id = "q5maths4",
                questionText = "What is the cosine of 60°?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "1/2",
                difficulty = Difficult.EASY,
                unitId = trigId
            ),
            Question(
                id = "q6maths4",
                questionText = "Find the value of sin(90°).",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "1",
                difficulty = Difficult.MEDIUM,
                unitId = trigId
            ),
            Question(
                id = "q7maths4",
                questionText = "What is the value of tan(45°)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("1", "√3", "0"),
                correctAnswer = "1",
                difficulty = Difficult.HARD,
                unitId = trigId
            ),
            Question(
                id = "q9maths4",
                questionText = "What is the value of tan(60°)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("√3", "1/√3", "1"),
                correctAnswer = "√3",
                difficulty = Difficult.MEDIUM,
                unitId = trigId
            ),
            Question(
                id = "q10maths4",
                questionText = "Find the value of sin(120°).",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "√3/2",
                difficulty = Difficult.HARD,
                unitId = trigId
            ),
            Question(
                id = "q11maths4",
                questionText = "What is the value of cos(45°)?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "√2/2",
                difficulty = Difficult.MEDIUM,
                unitId = trigId
            ),
            Question(
                id = "q12maths4",
                questionText = "The value of cos(60°) is equal to sin(30°).",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = trigId
            ),
            Question(
                id = "q13maths4",
                questionText = "What is the value of sin(150°)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("1/2", "√3/2", "√2/2"),
                correctAnswer = "1/2",
                difficulty = Difficult.HARD,
                unitId = trigId
            ),
            Question(
                id = "q14maths4",
                questionText = "What is the value of tan(120°)?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "-√3",
                difficulty = Difficult.HARD,
                unitId = trigId
            ),
        )
    }


    fun generateEquationsQuestions(equationsId: String): List<Question> {
        return listOf(
            Question(
                id = "q1maths5",
                questionText = "Solve the equation: 2x + 3 = 7",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 2",
                difficulty = Difficult.EASY,
                unitId = equationsId
            ),
            Question(
                id = "q2maths5",
                questionText = "Solve for x: 3(x - 2) = 9",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 5",
                difficulty = Difficult.MEDIUM,
                unitId = equationsId
            ),
            Question(
                id = "q3maths5",
                questionText = "The equation 4x - 5 = 15 has one solution.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = equationsId
            ),
            Question(
                id = "q4maths5",
                questionText = "The equation 2(x + 4) = 2x + 8 has no solution.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                unitId = equationsId
            ),
            Question(
                id = "q5maths5",
                questionText = "Solve for x: 5x = 25",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 5",
                difficulty = Difficult.EASY,
                unitId = equationsId
            ),
            Question(
                id = "q6maths5",
                questionText = "Solve for x: 2x - 3 = 7",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 5",
                difficulty = Difficult.MEDIUM,
                unitId = equationsId
            ),
            Question(
                id = "q7maths5",
                questionText = "Solve for x: 3x + 4 = 2(x - 1)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = -6",
                difficulty = Difficult.HARD,
                unitId = equationsId
            ),
            Question(
                id = "q8maths5",
                questionText = "Solve the equation: x/2 + 3 = 7",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 8",
                difficulty = Difficult.HARD,
                unitId = equationsId
            ),

            Question(
                id = "q10maths5",
                questionText = "Solve for x: x + 3 = 2x + 1",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 2",
                difficulty = Difficult.HARD,
                unitId = equationsId
            ),
            Question(
                id = "q11maths5",
                questionText = "Solve for x: 4x - 8 = 12",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 5",
                difficulty = Difficult.MEDIUM,
                unitId = equationsId
            ),
            Question(
                id = "q12maths5",
                questionText = "The equation x² - 4x + 4 = 0 has two solutions.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = equationsId
            ),
            Question(
                id = "q13maths5",
                questionText = "Solve for x: 3(x + 2) = 18",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 4",
                difficulty = Difficult.MEDIUM,
                unitId = equationsId
            ),
            Question(
                id = "q14maths5",
                questionText = "Solve for x: 2(x + 5) = 3x - 4",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 14",
                difficulty = Difficult.HARD,
                unitId = equationsId
            ),
            Question(
                id = "q15maths5",
                questionText = "Solve for x: 4(x - 3) = 2x + 6",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 6",
                difficulty = Difficult.HARD,
                unitId = equationsId
            ),
            Question(
                id = "q16maths5",
                questionText = "Solve for x: x - 4 = 8",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "x = 12",
                difficulty = Difficult.EASY,
                unitId = equationsId
            )
        )
    }
}
