package com.uc3m.android.helloworld.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

data class DictionaryResponse(
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>,
    val license: License,
    val sourceUrls: List<String>
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>
)

data class Definition(
    val definition: String,
    val example: String?
)

data class License(
    val name: String,
    val url: String
)

interface DictionaryService {
    @GET("entries/en/{word}")
    suspend fun getWordDefinition(@Path("word") word: String): List<DictionaryResponse>
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationalFactsScreen(navController: NavController) {
    var word by remember { mutableStateOf("") }
    var definition by remember { mutableStateOf("") }
    var example by remember { mutableStateOf("") }
    var partOfSpeech by remember { mutableStateOf("") }
    var phonetic by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var searchQuery by remember { mutableStateOf("") }
    var showSearch by remember { mutableStateOf(false) }
    var usedWords by remember { mutableStateOf(setOf<String>()) }
    val scope = rememberCoroutineScope()
    
    val dictionaryService = remember {
        Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryService::class.java)
    }

    val interestingWords = listOf(
        // Palabras sobre naturaleza y ciencia
        "serendipity", "ephemeral", "luminous", "ethereal", "cascade",
        "nebula", "aurora", "cosmos", "galaxy", "constellation",
        "molecule", "atom", "electron", "neutron", "proton",
        "photosynthesis", "respiration", "ecosystem", "biodiversity", "evolution",
        
        // Palabras sobre emociones y estados
        "whimsical", "resilient", "enigmatic", "mystical", "tranquil",
        "effervescent", "melancholy", "euphoria", "nostalgia", "serenity",
        "empathy", "compassion", "gratitude", "wonder", "curiosity",
        "resilience", "perseverance", "determination", "inspiration", "motivation",
        
        // Palabras sobre arte y creatividad
        "quintessential", "aesthetic", "symphony", "harmony", "rhythm",
        "melody", "canvas", "palette", "sculpture", "masterpiece",
        "inspiration", "imagination", "creativity", "innovation", "expression",
        "artistry", "craftsmanship", "elegance", "grace", "beauty",
        
        // Palabras sobre filosofía y pensamiento
        "philosophy", "wisdom", "knowledge", "understanding", "insight",
        "contemplation", "reflection", "meditation", "awareness", "consciousness",
        "reasoning", "logic", "analysis", "synthesis", "perspective",
        "paradigm", "concept", "theory", "principle", "truth",
        
        // Palabras sobre aventura y exploración
        "adventure", "expedition", "journey", "quest", "discovery",
        "exploration", "wanderlust", "nomadic", "pioneer", "trailblazer",
        "expedition", "voyage", "odyssey", "pilgrimage", "wanderer",
        "explorer", "adventurer", "pioneer", "trailblazer", "wanderer",
        
        // Palabras sobre tiempo y espacio
        "eternity", "infinity", "moment", "timeless", "eternal",
        "cosmic", "celestial", "astronomical", "universal", "infinite",
        "temporal", "spatial", "dimensional", "chronological", "sequential",
        "simultaneous", "synchronous", "asynchronous", "perpetual", "endless",
        
        // Palabras sobre misterio y enigma
        "enigmatic", "mysterious", "cryptic", "puzzling", "perplexing",
        "baffling", "bewildering", "confounding", "intriguing", "fascinating",
        "mystical", "esoteric", "arcane", "occult", "supernatural",
        "phenomenon", "anomaly", "paradox", "conundrum", "riddle",
        
        // Palabras sobre transformación y cambio
        "metamorphosis", "transformation", "evolution", "adaptation", "mutation",
        "transition", "transformation", "change", "growth", "development",
        "progress", "advancement", "improvement", "enhancement", "refinement",
        "evolution", "adaptation", "modification", "alteration", "variation",
        
        // Palabras sobre armonía y balance
        "harmony", "balance", "equilibrium", "symmetry", "proportion",
        "rhythm", "flow", "grace", "elegance", "beauty",
        "synchrony", "coordination", "integration", "unification", "synthesis",
        "coherence", "consistency", "stability", "steadiness", "reliability",
        
        // Palabras sobre luz y energía
        "luminous", "radiant", "brilliant", "glowing", "shining",
        "sparkling", "twinkling", "gleaming", "flashing", "blazing",
        "energy", "power", "force", "strength", "vigor",
        "vitality", "dynamism", "intensity", "potency", "efficiency"
    )

    val blackColor = Color(0xFF000000)
    val naranjitafondo = Color(0xFFFF9966)

    fun updateWordInfo(entry: DictionaryResponse) {
        word = entry.word
        phonetic = entry.phonetic ?: ""
        val firstMeaning = entry.meanings.firstOrNull()
        if (firstMeaning != null) {
            partOfSpeech = firstMeaning.partOfSpeech
            val firstDefinition = firstMeaning.definitions.firstOrNull()
            if (firstDefinition != null) {
                definition = firstDefinition.definition
                example = firstDefinition.example ?: ""
            }
        }
        usedWords = usedWords + entry.word
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Dictionary",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                actions = {
                    IconButton(onClick = { showSearch = !showSearch }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF9966),
                    titleContentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFFF5F5F5))
            ) {
                NavigationBar(
                    containerColor = Color.Transparent,
                    contentColor = blackColor,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                ) {
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "📚",
                                        fontSize = 20.sp,
                                        color = naranjitafondo,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("subjects") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "📅",
                                        fontSize = 20.sp,
                                        color = naranjitafondo,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("study_plans") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = "Home",
                                        tint = Color.White,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("home") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(96.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(96.dp)
                                        .background(naranjitafondo, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "📊",
                                        fontSize = 24.sp,
                                        color = Color.White,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = true,
                        onClick = {  }, //already on educational_facts
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent,
                            indicatorColor = Color(0xFFF5F5F5)
                        )
                    )
                    NavigationBarItem(
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .background(Color(0xFFAAAAAA), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "💾",
                                        fontSize = 20.sp,
                                        color = naranjitafondo,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        },
                        selected = false,
                        onClick = { navController.navigate("offline_mode") },
                        label = null,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            if (showSearch) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Search word") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    singleLine = true
                )
            }

            if (isLoading) {
                CircularProgressIndicator()
            } else {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f)
                        .padding(horizontal = 16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (errorMessage.isNotEmpty()) {
                            Text(
                                text = errorMessage,
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.error
                            )
                        } else {
                            if (word.isNotEmpty()) {
                                Text(
                                    text = word,
                                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                if (phonetic.isNotEmpty()) {
                                    Text(
                                        text = phonetic,
                                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                if (partOfSpeech.isNotEmpty()) {
                                    Text(
                                        text = partOfSpeech,
                                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp),
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                if (definition.isNotEmpty()) {
                                    Text(
                                        text = definition,
                                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                if (example.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Text(
                                        text = "Example: $example",
                                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            isLoading = true
                            errorMessage = ""
                            try {
                                var attempts = 0
                                var found = false
                                while (attempts < 10 && !found) {
                                    val randomWord = interestingWords.random()
                                    if (!usedWords.contains(randomWord)) {
                                        val response = dictionaryService.getWordDefinition(randomWord)
                                        val firstEntry = response.firstOrNull()
                                        if (firstEntry != null) {
                                            updateWordInfo(firstEntry)
                                            found = true
                                        }
                                    }
                                    attempts++
                                }
                                
                                if (!found) {
                                    errorMessage = "No se encontraron más palabras nuevas"
                                }
                            } catch (e: Exception) {
                                errorMessage = "Error: ${e.message}"
                                word = ""
                                definition = ""
                                example = ""
                                partOfSpeech = ""
                                phonetic = ""
                            }
                            isLoading = false
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Generate Random Word")
                }

                if (showSearch && searchQuery.isNotEmpty()) {
                    Button(
                        onClick = {
                            scope.launch {
                                isLoading = true
                                errorMessage = ""
                                try {
                                    val response = dictionaryService.getWordDefinition(searchQuery)
                                    val firstEntry = response.firstOrNull()
                                    
                                    if (firstEntry != null) {
                                        updateWordInfo(firstEntry)
                                    } else {
                                        errorMessage = "The word is not defined in the English language"
                                    }
                                } catch (e: Exception) {
                                    if (e.message?.contains("404") == true) {
                                        errorMessage = "The word is not defined in the English language"
                                    } else {
                                        errorMessage = "Error: ${e.message}"
                                    }
                                    word = ""
                                    definition = ""
                                    example = ""
                                    partOfSpeech = ""
                                    phonetic = ""
                                }
                                isLoading = false
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Search")
                    }
                }
            }
        }
    }
}

