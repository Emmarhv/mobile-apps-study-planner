package com.uc3m.android.helloworld.data

class ScienceQuestions {
    // Function to generate the list of Kinematics and Dynamics questions
    fun generateKinematicsQuestions(kinematicsDynamicsId: String): List<Question> {
        return listOf(
            Question(
                id = "q1science1",
                questionText = "If an object is moving at a constant velocity, what is its acceleration? (units in m/s²)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "0",
                difficulty = Difficult.EASY,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q2science1",
                questionText = "A car accelerates from 0 to 20 m/s in 5 seconds. What is its average acceleration? (units in m/s²)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "4",
                difficulty = Difficult.MEDIUM,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q3science1",
                questionText = "A car moves with an acceleration of 2 m/s² for 10 seconds. What is the final velocity? (units in m/s)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "20",
                difficulty = Difficult.MEDIUM,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q4science1",
                questionText = "If a 10 kg object experiences a force of 50 N, what is its acceleration? (units in m/s²)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "5",
                difficulty = Difficult.HARD,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q5science1",
                questionText = "A rocket is launched straight upward with an initial velocity of 30 m/s. What is its velocity after 5 seconds if the acceleration due to gravity is -9.8 m/s²? (units in m/s)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "-19",
                difficulty = Difficult.HARD,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q6science1",
                questionText = "A ball is thrown vertically upwards with a speed of 20 m/s. How high will it rise before coming to a stop? (units in m)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "20.4",
                difficulty = Difficult.HARD,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q7science1",
                questionText = "If an object has a mass of 5 kg and a velocity of 3 m/s, what is its momentum? (units in kg·m/s)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "15",
                difficulty = Difficult.MEDIUM,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q8science1",
                questionText = "What is the force required to accelerate a 10 kg object at 2 m/s²? (units in N)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "20",
                difficulty = Difficult.HARD,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q9science1",
                questionText = "What is the unit of acceleration in the International System of Units (SI)?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("m/s", "m/s²", "kg", "N"),
                correctAnswer = "m/s²",
                difficulty = Difficult.EASY,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q10science1",
                questionText = "The force of gravity on Earth is approximately 9.8 N/kg.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q11science1",
                questionText = "Newton's first law states that an object at rest will remain at rest unless acted upon by an external force.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q13science1",
                questionText = "The acceleration due to gravity decreases with height above the Earth's surface.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q14science1",
                questionText = "A body moves in a circular path with a constant speed. What type of acceleration does the body experience?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Centripetal acceleration", "Linear acceleration", "Angular acceleration", "No acceleration"),
                correctAnswer = "Centripetal acceleration",
                difficulty = Difficult.HARD,
                unitId = kinematicsDynamicsId
            ),

            Question(
                id = "q15science1",
                questionText = "Inertia is the tendency of an object to resist changes in its motion.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = kinematicsDynamicsId
            ),
        )
    }


    fun generateWorkEnergyPowerQuestions(workEnergyPowerId: String): List<Question> {
        return listOf(
            // SHORT ANSWER - EASY
            Question(
                id = "q1science2",
                questionText = "How much work is done when a 10 N force moves an object 3 m? (answer in J)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "30",
                difficulty = Difficult.EASY,
                unitId = workEnergyPowerId
            ),
            Question(
                id = "q2science2",
                questionText = "What is the kinetic energy of a 2 kg object moving at 4 m/s? (answer in J)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "16",
                difficulty = Difficult.EASY,
                unitId = workEnergyPowerId
            ),

            // TRUE/FALSE - EASY
            Question(
                id = "q3science2",
                questionText = "Power is defined as the rate at which work is done.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = workEnergyPowerId
            ),
            Question(
                id = "q4science2",
                questionText = "An object has no energy if it's not moving.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = workEnergyPowerId
            ),

            // MULTIPLE CHOICE - EASY
            Question(
                id = "q5science2",
                questionText = "Which of the following is a correct unit for work?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Joule", "Watt", "Newton", "Pascal"),
                correctAnswer = "Joule",
                difficulty = Difficult.EASY,
                unitId = workEnergyPowerId
            ),
            Question(
                id = "q6science2",
                questionText = "What form of energy is stored due to an object’s position?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Kinetic", "Thermal", "Potential", "Nuclear"),
                correctAnswer = "Potential",
                difficulty = Difficult.EASY,
                unitId = workEnergyPowerId
            ),


            // SHORT ANSWER - MEDIUM
            Question(
                id = "q8science2",
                questionText = "A 5 kg object is lifted 10 m. What is its potential energy? (g = 9.8 m/s², answer in J)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "490",
                difficulty = Difficult.MEDIUM,
                unitId = workEnergyPowerId
            ),
            Question(
                id = "q9science2",
                questionText = "How much power is needed to do 120 J of work in 4 seconds? (answer in W)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "30",
                difficulty = Difficult.MEDIUM,
                unitId = workEnergyPowerId
            ),

            // TRUE/FALSE - MEDIUM
            Question(
                id = "q10science2",
                questionText = "A 60 W bulb uses more energy in one hour than a 100 W bulb.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                unitId = workEnergyPowerId
            ),

            // MULTIPLE CHOICE - MEDIUM
            Question(
                id = "q11science2",
                questionText = "Which formula correctly defines power?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Power = Work × Time", "Power = Work / Time", "Power = Force × Time", "Power = Energy × Time"),
                correctAnswer = "Power = Work / Time",
                difficulty = Difficult.MEDIUM,
                unitId = workEnergyPowerId
            ),


            // SHORT ANSWER - HARD
            Question(
                id = "q13science2",
                questionText = "How much energy (in J) is consumed by a 1500 W heater used for 3 minutes?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "270000",
                difficulty = Difficult.HARD,
                unitId = workEnergyPowerId
            ),

            // MULTIPLE CHOICE - HARD
            Question(
                id = "q14science2",
                questionText = "Which of the following is NOT a form of mechanical energy?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Potential", "Thermal", "Kinetic", "Gravitational"),
                correctAnswer = "Thermal",
                difficulty = Difficult.HARD,
                unitId = workEnergyPowerId
            ),

            // TRUE/FALSE - HARD
            Question(
                id = "q15science2",
                questionText = "Energy can be created as long as it is used efficiently.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = workEnergyPowerId
            )
        )
    }


    fun generateForcesNewtonsLawsQuestions(forcesNewtonLawsId: String): List<Question> {
        return listOf(
            // SHORT ANSWER - EASY
            Question(
                id = "q1science3",
                questionText = "What is the net force on a 2 kg object accelerating at 3 m/s²? (answer in N)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "6",
                difficulty = Difficult.EASY,
                unitId = forcesNewtonLawsId
            ),
            Question(
                id = "q2science3",
                questionText = "According to Newton’s First Law, what keeps an object at rest? (one word)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "inertia",
                difficulty = Difficult.EASY,
                unitId = forcesNewtonLawsId
            ),

            // TRUE/FALSE - EASY
            Question(
                id = "q3science3",
                questionText = "A force is required to keep an object moving at constant velocity.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = forcesNewtonLawsId
            ),
            Question(
                id = "q4science3",
                questionText = "Friction always acts in the opposite direction of motion.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = forcesNewtonLawsId
            ),

            // MULTIPLE CHOICE - EASY
            Question(
                id = "q5science3",
                questionText = "What is the unit of force?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Joule", "Watt", "Newton", "Pascal"),
                correctAnswer = "Newton",
                difficulty = Difficult.EASY,
                unitId = forcesNewtonLawsId
            ),
            Question(
                id = "q6science3",
                questionText = "Which law explains why we wear seatbelts in a car?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Newton’s First Law", "Newton’s Second Law", "Newton’s Third Law", "Law of Gravity"),
                correctAnswer = "Newton’s First Law",
                difficulty = Difficult.EASY,
                unitId = forcesNewtonLawsId
            ),

            // SHORT ANSWER - MEDIUM
            Question(
                id = "q8science3",
                questionText = "An object is acted on by a 10 N force and accelerates at 2 m/s². What is its mass? (answer in kg)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "5",
                difficulty = Difficult.MEDIUM,
                unitId = forcesNewtonLawsId
            ),
            Question(
                id = "q9science3",
                questionText = "What is the acceleration of a 4 kg object under a net force of 8 N? (answer in m/s²)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "2",
                difficulty = Difficult.MEDIUM,
                unitId = forcesNewtonLawsId
            ),

            // TRUE/FALSE - MEDIUM
            Question(
                id = "q10science3",
                questionText = "According to Newton's Third Law, forces always come in pairs.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = forcesNewtonLawsId
            ),

            // MULTIPLE CHOICE - MEDIUM
            Question(
                id = "q11science3",
                questionText = "Which of the following is an example of Newton’s Third Law?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Pushing a wall and feeling it push back", "A ball rolling down a hill", "Gravity pulling an object down", "A satellite orbiting Earth"),
                correctAnswer = "Pushing a wall and feeling it push back",
                difficulty = Difficult.MEDIUM,
                unitId = forcesNewtonLawsId
            ),


            // SHORT ANSWER - HARD
            Question(
                id = "q13science3",
                questionText = "What is the net force (in N) on a 3 kg object accelerating at 6.5 m/s²?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "19.5",
                difficulty = Difficult.HARD,
                unitId = forcesNewtonLawsId
            ),

            // MULTIPLE CHOICE - HARD
            Question(
                id = "q14science3",
                questionText = "Which factor does NOT affect the force of friction?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Type of surfaces", "Normal force", "Surface area", "Mass of the object"),
                correctAnswer = "Surface area",
                difficulty = Difficult.HARD,
                unitId = forcesNewtonLawsId
            ),

            // TRUE/FALSE - HARD
            Question(
                id = "q15science3",
                questionText = "A heavier object always experiences greater acceleration under the same force.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = forcesNewtonLawsId
            )
        )
    }


    fun generatePeriodicTableQuestions(atomicStructurePeriodicTableId: String): List<Question> {
        return listOf(
            // SHORT ANSWER - EASY
            Question(
                questionText = "What is the atomic number of carbon?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "6",
                difficulty = Difficult.EASY,
                unitId = atomicStructurePeriodicTableId,
                id = "q1science4"
            ),
            Question(
                questionText = "What is the name of the particle with a negative charge?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "electron",
                difficulty = Difficult.EASY,
                unitId = atomicStructurePeriodicTableId,
                id = "q2science4"
            ),

            // TRUE/FALSE - EASY
            Question(
                questionText = "Neutrons are positively charged particles.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = atomicStructurePeriodicTableId,
                id = "q3science4"
            ),
            Question(
                questionText = "Elements in the same group have similar chemical properties.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = atomicStructurePeriodicTableId,
                id = "q4science4"
            ),

            // MULTIPLE CHOICE - EASY
            Question(
                questionText = "Where are electrons found in an atom?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("In the nucleus", "Orbiting the nucleus", "Inside protons", "Between atoms"),
                correctAnswer = "Orbiting the nucleus",
                difficulty = Difficult.EASY,
                unitId = atomicStructurePeriodicTableId,
                id = "q5science4"
            ),
            Question(
                questionText = "What is the charge of a neutron?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Positive", "Negative", "Neutral", "It depends"),
                correctAnswer = "Neutral",
                difficulty = Difficult.EASY,
                unitId = atomicStructurePeriodicTableId,
                id = "q6science4"
            ),

            // SHORT ANSWER - MEDIUM
            Question(
                questionText = "How many electrons does a neutral oxygen atom have?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "8",
                difficulty = Difficult.MEDIUM,
                unitId = atomicStructurePeriodicTableId,
                id = "q8science4"
            ),
            Question(
                questionText = "What is the total number of protons and neutrons in an atom called?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "mass number",
                difficulty = Difficult.MEDIUM,
                unitId = atomicStructurePeriodicTableId,
                id = "q9science4"
            ),

            // TRUE/FALSE - MEDIUM
            Question(
                questionText = "The atomic number is equal to the number of protons in an atom.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = atomicStructurePeriodicTableId,
                id = "q10science4"
            ),

            // MULTIPLE CHOICE - MEDIUM
            Question(
                questionText = "What information does the period number of an element provide?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf(
                    "Number of neutrons",
                    "Number of protons",
                    "Number of energy levels",
                    "Atomic mass"
                ),
                correctAnswer = "Number of energy levels",
                difficulty = Difficult.MEDIUM,
                unitId = atomicStructurePeriodicTableId,
                id = "q11science4"
            ),


            // SHORT ANSWER - HARD
            Question(
                questionText = "What is the atomic mass of oxygen? (round to the nearest whole number)",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "16",
                difficulty = Difficult.HARD,
                unitId = atomicStructurePeriodicTableId,
                id = "q13science4"
            ),

            // MULTIPLE CHOICE - HARD
            Question(
                questionText = "Which of the following is an alkali metal?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Fluorine", "Calcium", "Sodium", "Helium"),
                correctAnswer = "Sodium",
                difficulty = Difficult.HARD,
                unitId = atomicStructurePeriodicTableId,
                id = "q14science4"
            ),

            // TRUE/FALSE - HARD
            Question(
                questionText = "Elements are arranged in the periodic table by increasing atomic mass.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = atomicStructurePeriodicTableId,
                id = "q15science4"
            )
        )
    }


    fun generateChemicalBondingQuestions(chemicalBondingId: String): List<Question> {
        return listOf(
            // SHORT ANSWER - EASY
            Question(
                questionText = "What type of bond is formed when electrons are shared?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "covalent",
                difficulty = Difficult.EASY,
                unitId = chemicalBondingId,
                id = "q1science5"
            ),
            Question(
                questionText = "How many electrons are shared in a single covalent bond?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "2",
                difficulty = Difficult.EASY,
                unitId = chemicalBondingId,
                id = "q2science5"
            ),

            // TRUE/FALSE - EASY
            Question(
                questionText = "Ionic bonds form between metals and nonmetals.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = chemicalBondingId,
                id = "q3science5"
            ),
            Question(
                questionText = "A covalent bond involves the transfer of electrons.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = chemicalBondingId,
                id = "q4science5"
            ),

            // MULTIPLE CHOICE - EASY
            Question(
                questionText = "Which type of bond forms between sodium and chlorine?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Covalent", "Metallic", "Hydrogen", "Ionic"),
                correctAnswer = "Ionic",
                difficulty = Difficult.EASY,
                unitId = chemicalBondingId,
                id = "q5science5"
            ),
            Question(
                questionText = "What is the name of the attraction between oppositely charged ions?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Hydrogen bond", "Metallic bond", "Ionic bond", "Covalent bond"),
                correctAnswer = "Ionic bond",
                difficulty = Difficult.EASY,
                unitId = chemicalBondingId,
                id = "q6science5"
            ),


            // SHORT ANSWER - MEDIUM
            Question(
                questionText = "How many covalent bonds can a carbon atom form?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "4",
                difficulty = Difficult.MEDIUM,
                unitId = chemicalBondingId,
                id = "q8science5"
            ),
            Question(
                questionText = "What is the name of the bond formed between hydrogen and oxygen in a water molecule?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "covalent",
                difficulty = Difficult.MEDIUM,
                unitId = chemicalBondingId,
                id = "q9science5"
            ),

            // TRUE/FALSE - MEDIUM
            Question(
                questionText = "Metallic bonds are responsible for the electrical conductivity of metals.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = chemicalBondingId,
                id = "q10science5"
            ),

            // MULTIPLE CHOICE - MEDIUM
            Question(
                questionText = "Which of these is a property of substances with ionic bonds?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf(
                    "Low melting point",
                    "Poor conductivity when melted",
                    "Solubility in water",
                    "Soft texture"
                ),
                correctAnswer = "Solubility in water",
                difficulty = Difficult.MEDIUM,
                unitId = chemicalBondingId,
                id = "q11science5"
            ),


            // SHORT ANSWER - HARD
            Question(
                questionText = "How many electrons are in a double covalent bond?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "4",
                difficulty = Difficult.HARD,
                unitId = chemicalBondingId,
                id = "q13science5"
            ),

            // MULTIPLE CHOICE - HARD
            Question(
                questionText = "Which of the following has metallic bonding?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Diamond", "Sodium", "Water", "Carbon dioxide"),
                correctAnswer = "Sodium",
                difficulty = Difficult.HARD,
                unitId = chemicalBondingId,
                id = "q14science5"
            ),

            // TRUE/FALSE - HARD
            Question(
                questionText = "A molecule of nitrogen (N₂) contains a triple bond.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = chemicalBondingId,
                id = "q15science5"
            )
        )
    }

}