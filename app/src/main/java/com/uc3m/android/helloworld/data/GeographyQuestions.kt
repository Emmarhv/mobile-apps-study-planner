package com.uc3m.android.helloworld.data

class GeographyQuestions {
    fun generatePhysicalGeographyQuestions(physicalGeographyId: String): List<Question> {
        return listOf(
            // SHORT ANSWER - EASY
            Question(
                id = "q1geo1",
                questionText = "What is the Earth's largest ocean?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Pacific",
                difficulty = Difficult.EASY,
                unitId = physicalGeographyId
            ),
            Question(
                id = "q2geo1",
                questionText = "Which is the highest mountain on Earth?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "Everest",
                difficulty = Difficult.EASY,
                unitId = physicalGeographyId
            ),

            // TRUE_FALSE - EASY
            Question(
                id = "q3geo1",
                questionText = "Rivers flow from higher to lower ground.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = physicalGeographyId
            ),
            Question(
                id = "q4geo1",
                questionText = "A desert is defined by its temperature.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = physicalGeographyId
            ),

            // MULTIPLE CHOICE - EASY
            Question(
                id = "q5geo1",
                questionText = "Which of these is a landform created by erosion?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Delta", "Canyon", "Volcano", "Plateau"),
                correctAnswer = "Canyon",
                difficulty = Difficult.EASY,
                unitId = physicalGeographyId
            ),
            Question(
                id = "q6geo1",
                questionText = "Which landform is found under the ocean?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Plain", "Mountain", "Trench", "Mesa"),
                correctAnswer = "Trench",
                difficulty = Difficult.EASY,
                unitId = physicalGeographyId
            ),


            // SHORT ANSWER - MEDIUM
            Question(
                id = "q8geo1",
                questionText = "Name the layer of Earth where tectonic plates move.",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "lithosphere",
                difficulty = Difficult.MEDIUM,
                unitId = physicalGeographyId
            ),
            Question(
                id = "q9geo1",
                questionText = "What do we call a chain of mountains?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "range",
                difficulty = Difficult.MEDIUM,
                unitId = physicalGeographyId
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                id = "q10geo1",
                questionText = "Earthquakes are usually caused by volcanic eruptions.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                unitId = physicalGeographyId
            ),

            // MULTIPLE CHOICE - MEDIUM
            Question(
                id = "q11geo1",
                questionText = "Which of the following is formed by a convergent plate boundary?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Rift valley", "Mid-ocean ridge", "Mountain range", "Ocean trench"),
                correctAnswer = "Mountain range",
                difficulty = Difficult.MEDIUM,
                unitId = physicalGeographyId
            ),

            // SHORT ANSWER - HARD
            Question(
                id = "q13geo1",
                questionText = "What is the term for a flat, elevated landform?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "plateau",
                difficulty = Difficult.HARD,
                unitId = physicalGeographyId
            ),

            // MULTIPLE CHOICE - HARD
            Question(
                id = "q14geo1",
                questionText = "Which process is most responsible for shaping coastal cliffs?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Deposition", "Erosion", "Tectonics", "Sedimentation"),
                correctAnswer = "Erosion",
                difficulty = Difficult.HARD,
                unitId = physicalGeographyId
            ),

            // TRUE_FALSE - HARD
            Question(
                id = "q15geo1",
                questionText = "Volcanic islands can form from underwater eruptions.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.HARD,
                unitId = physicalGeographyId
            )
        )
    }

    fun generateClimateAndWeatherQuestions(climateId: String): List<Question> {
        return listOf(
            // SHORT ANSWER - EASY
            Question(
                id = "q1climate2",
                questionText = "What is the term for the average weather conditions over a long period?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "climate",
                difficulty = Difficult.EASY,
                unitId = climateId
            ),
            Question(
                id = "q2climate2",
                questionText = "Which instrument is used to measure temperature?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "thermometer",
                difficulty = Difficult.EASY,
                unitId = climateId
            ),

            // TRUE_FALSE - EASY
            Question(
                id = "q3climate2",
                questionText = "Rain is a type of precipitation.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = climateId
            ),
            Question(
                id = "q4climate2",
                questionText = "The equator experiences the coldest temperatures.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = climateId
            ),

            // MULTIPLE CHOICE - EASY
            Question(
                id = "q5climate2",
                questionText = "Which of the following is NOT a type of precipitation?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Rain", "Snow", "Wind", "Hail"),
                correctAnswer = "Wind",
                difficulty = Difficult.EASY,
                unitId = climateId
            ),
            Question(
                id = "q6climate2",
                questionText = "What kind of climate do rainforests have?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Arid", "Tropical", "Temperate", "Polar"),
                correctAnswer = "Tropical",
                difficulty = Difficult.EASY,
                unitId = climateId
            ),

            // SHORT ANSWER - MEDIUM
            Question(
                id = "q8climate2",
                questionText = "What is the name of the wind belt near the equator with calm air?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "doldrums",
                difficulty = Difficult.MEDIUM,
                unitId = climateId
            ),
            Question(
                id = "q9climate2",
                questionText = "What gas is most responsible for the greenhouse effect?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "carbon dioxide",
                difficulty = Difficult.MEDIUM,
                unitId = climateId
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                id = "q10climate2",
                questionText = "A cold front usually brings clear skies and calm weather.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.MEDIUM,
                unitId = climateId
            ),

            // MULTIPLE CHOICE - MEDIUM
            Question(
                id = "q11climate2",
                questionText = "Which of the following describes a Mediterranean climate?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Hot and dry all year", "Mild wet winters, hot dry summers", "Cold and snowy", "Rainy all year"),
                correctAnswer = "Mild wet winters, hot dry summers",
                difficulty = Difficult.MEDIUM,
                unitId = climateId
            ),

            // SHORT ANSWER - HARD
            Question(
                id = "q13climate2",
                questionText = "What is the name for a large body of air with uniform temperature and humidity?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "air mass",
                difficulty = Difficult.HARD,
                unitId = climateId
            ),

            // MULTIPLE CHOICE - HARD
            Question(
                id = "q14climate2",
                questionText = "Which global wind belt is responsible for moving weather systems across Europe?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Polar easterlies", "Trade winds", "Westerlies", "Doldrums"),
                correctAnswer = "Westerlies",
                difficulty = Difficult.HARD,
                unitId = climateId
            ),

            // TRUE_FALSE - HARD
            Question(
                id = "q15climate2",
                questionText = "Climate change only affects air temperature and has no impact on weather patterns.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = climateId
            )
        )
    }


    fun generatePopulationAndEconomicsQuestions(populationEconomicsId: String): List<Question> {
        return listOf(
            // SHORT ANSWER - EASY
            Question(
                questionText = "What is the term for the number of people living in a given area?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "population density",
                difficulty = Difficult.EASY,
                unitId = populationEconomicsId,
                id = "q1geo3"
            ),
            Question(
                questionText = "What type of economy is based on farming and handmade goods?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "traditional economy",
                difficulty = Difficult.EASY,
                unitId = populationEconomicsId,
                id = "q2geo3"
            ),

            // TRUE_FALSE - EASY
            Question(
                questionText = "Birth rate is the number of births per year per 1,000 people.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.EASY,
                unitId = populationEconomicsId,
                id = "q3geo3"
            ),
            Question(
                questionText = "A higher death rate leads to rapid population growth.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.EASY,
                unitId = populationEconomicsId,
                id = "q4geo3"
            ),

            // MULTIPLE CHOICE - EASY
            Question(
                questionText = "Which of the following is a secondary economic activity?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Fishing", "Mining", "Manufacturing", "Farming"),
                correctAnswer = "Manufacturing",
                difficulty = Difficult.EASY,
                unitId = populationEconomicsId,
                id = "q5geo3"
            ),
            Question(
                questionText = "Which factor usually causes people to migrate?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Natural beauty", "Job opportunities", "Entertainment", "Climate"),
                correctAnswer = "Job opportunities",
                difficulty = Difficult.EASY,
                unitId = populationEconomicsId,
                id = "q6geo3"
            ),

            // SHORT ANSWER - MEDIUM
            Question(
                questionText = "What is the term for the movement of people from rural to urban areas?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "urbanization",
                difficulty = Difficult.MEDIUM,
                unitId = populationEconomicsId,
                id = "q8geo3"
            ),
            Question(
                questionText = "What is the name of the measurement used to compare a country's imports and exports?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "balance of trade",
                difficulty = Difficult.MEDIUM,
                unitId = populationEconomicsId,
                id = "q9geo3"
            ),

            // TRUE_FALSE - MEDIUM
            Question(
                questionText = "The service sector includes jobs like doctors, teachers, and taxi drivers.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = true,
                difficulty = Difficult.MEDIUM,
                unitId = populationEconomicsId,
                id = "q10geo3"
            ),

            // MULTIPLE CHOICE - MEDIUM
            Question(
                questionText = "Which continent currently has the highest population growth rate?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("Europe", "Asia", "Africa", "South America"),
                correctAnswer = "Africa",
                difficulty = Difficult.MEDIUM,
                unitId = populationEconomicsId,
                id = "q11geo3"
            ),

            // SHORT ANSWER - HARD
            Question(
                questionText = "What economic indicator measures the total value of goods and services produced in a country?",
                type = QuestionType.SHORT_ANSWER,
                correctAnswer = "GDP",
                difficulty = Difficult.HARD,
                unitId = populationEconomicsId,
                id = "q13geo3"
            ),

            // MULTIPLE CHOICE - HARD
            Question(
                questionText = "What is a major consequence of overpopulation in urban areas?",
                type = QuestionType.MULTIPLE_CHOICE,
                options = listOf("More green spaces", "Lower pollution", "Housing shortages", "Higher wages"),
                correctAnswer = "Housing shortages",
                difficulty = Difficult.HARD,
                unitId = populationEconomicsId,
                id = "q14geo3"
            ),

            // TRUE_FALSE - HARD
            Question(
                questionText = "Developed countries have a higher percentage of people working in primary activities.",
                type = QuestionType.TRUE_FALSE,
                correctAnswer = false,
                difficulty = Difficult.HARD,
                unitId = populationEconomicsId,
                id = "q15geo3"
            )
        )
    }

    fun generateSpanishAutonomousCommunitiesMapQuestions(spanishCommunitiesId: String): List<Question> {
        // Names that coincide with "NAME_1" of spain_communities.geojson
        val communities = listOf(
            "Andalucía",
            "Aragón",
            "Cantabria",
            "Castilla-LaMancha",
            "CastillayLeón",
            "Cataluña",
            "CeutayMelilla",
            "ComunidaddeMadrid",
            "ComunidadForaldeNavarra",
            "ComunidadValenciana",
            "Extremadura",
            "Galicia",
            "IslasBaleares",
            "IslasCanarias",
            "LaRioja",
            "PaísVasco",
            "PrincipadodeAsturias",
            "RegióndeMurcia"
        )
        return communities.mapIndexed { index, name ->
            Question(
                questionText   = "Tap the autonomous community of $name",
                type           = QuestionType.MAP,
                correctAnswer  = name,
                unitId         = spanishCommunitiesId,
                geoJsonAsset   = "spain_communities.geojson",
                regionProperty = "NAME_1",
                id = "q${index + 1}geo4"
            )
        }
    }

    fun generateSpanishProvincesMapQuestions(spanishProvincesId: String): List<Question> {
        // LNames that coincide with NAME_2 de spain_provincias.geojson
        val provinces = listOf(
            "Álava",
            "Albacete",
            "Alicante",
            "Almería",
            "Asturias",
            "Ávila",
            "Badajoz",
            "Baleares",
            "Barcelona",
            "Burgos",
            "Cáceres",
            "Cádiz",
            "Cantabria",
            "Castellón",
            "CiudadReal",
            "Córdoba",
            "Coruña",
            "Cuenca",
            "Girona",
            "Granada",
            "Guadalajara",
            "Guipúzcoa",
            "Huelva",
            "Huesca",
            "Jaén",
            "LaRioja",
            "LasPalmas",
            "León",
            "Lleida",
            "Lugo",
            "Madrid",
            "Málaga",
            "Murcia",
            "Navarra",
            "Ourense",
            "Palencia",
            "Pontevedra",
            "Salamanca",
            "SantaCruzdeTenerife",
            "Segovia",
            "Sevilla",
            "Soria",
            "Tarragona",
            "Teruel",
            "Toledo",
            "Valencia",
            "Valladolid",
            "Vizcaya",
            "Zamora",
            "Zaragoza"
        )

        val provinceQuestions = provinces.mapIndexed { index, name ->
            Question(
                questionText   = "Tap the Spanish province of $name",
                type           = QuestionType.MAP,
                correctAnswer  = name,
                unitId         = spanishProvincesId,
                geoJsonAsset   = "spain_provincias.geojson",
                regionProperty = "NAME_2",
                id             = "q${index + 1}_prov"
            )
        }

        // Capital-Community questions
        val communityCapitals = mapOf(
            "Andalusia"           to "Sevilla",
            "Catalonia"           to "Barcelona",
            "Community of Madrid" to "Madrid",
            "Castile–La Mancha"   to "Toledo",
            "Castile and León"    to "Valladolid",
            "Valencian Community" to "Valencia"
        )

        val startIdx = provinceQuestions.size
        // Convert into list to be able to use mapIndexed
        val capitalQuestions = communityCapitals
            .toList()  // List<Pair<String,String>>
            .mapIndexed { idx, (community, provinceName) ->Question(
                questionText   = "Tap the province that is the capital of $community",
                type           = QuestionType.MAP,
                correctAnswer  = provinceName,
                unitId         = spanishProvincesId,
                geoJsonAsset   = "spain_provincias.geojson",
                regionProperty = "NAME_2",
                difficulty     = Difficult.HARD,
                id             = "q${startIdx + idx + 1}_cap"
            )
            }

        return provinceQuestions + capitalQuestions
    }


    fun generateEuropeMapQuestions(europeId: String): List<Question> {
        // Names that coincide with europe.geojson → properties.name
        val countries = listOf(
            "Albania", "Austria", "Belarus", "Belgium", "Bosnia and Herz.",
            "Bulgaria", "Croatia", "Czechia", "Denmark", "Estonia",
            "Finland", "France", "Germany", "Greece", "Hungary",
            "Iceland", "Ireland", "Italy", "Kosovo", "Latvia",
            "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Moldova",
            "Monaco", "Montenegro", "Netherlands", "North Macedonia", "Norway",
            "Poland", "Portugal", "Romania", "Russia", "Serbia",
            "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland",
            "Ukraine", "United Kingdom"
        )

        // capital → country
        val capitalToCountry = mapOf(
            "Tirana"           to "Albania",
            "Vienna"           to "Austria",
            "Brussels"         to "Belgium",
            "Paris"            to "France",
            "Berlin"           to "Germany",
            "Rome"             to "Italy",
            "Madrid"           to "Spain",
            "Lisbon"           to "Portugal",
            "Warsaw"           to "Poland",
            "Athens"           to "Greece",
            "Copenhagen"       to "Denmark",
            "Budapest"         to "Hungary"
        )

        // Generate questions “Tap the country of X”
        val countryQuestions = countries.mapIndexed { idx, country ->
            Question(
                questionText   = "Tap the country of $country",
                type           = QuestionType.MAP,
                correctAnswer  = country,
                unitId         = europeId,
                geoJsonAsset   = "europe.geojson",
                regionProperty = "name",
                difficulty     = Difficult.MEDIUM,
                id             = "q${idx + 1}eur_map"
            )
        }

        // Generate questions “Tap the country whose capital is Y”
        val capitalQuestions = capitalToCountry.entries.mapIndexed { idx, (capital, country) ->
            Question(
                questionText   = "Tap the country whose capital is $capital",
                type           = QuestionType.MAP,
                correctAnswer  = country,
                unitId         = europeId,
                geoJsonAsset   = "europe.geojson",
                regionProperty = "name",
                difficulty     = Difficult.HARD,
                // to avoid repeating IDs of country questions
                id             = "q${countries.size + idx + 1}eur_cap"
            )
        }

        return countryQuestions + capitalQuestions
    }

}