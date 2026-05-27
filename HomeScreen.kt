                        // Top section with level progress and welcome message
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            // ... existing level progress and welcome text code ...
                        }

                        // Bottom section with vertical buttons
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .padding(bottom = 24.dp) // Add some padding at the bottom
                                .weight(1f), // This will make it take the remaining space
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly // Distribute space evenly
                        ) {
                            Button(
                                onClick = { navController.navigate("subjects") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp), // Slightly taller buttons
                                shape = RoundedCornerShape(60.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = naranjitafondo,
                                    contentColor = blackColor
                                )
                            ) {
                                Text("Subjects", fontSize = 16.sp, textAlign = TextAlign.Center)
                            }

                            Button(
                                onClick = { navController.navigate("study_plans") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp),
                                shape = RoundedCornerShape(60.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = naranjitafondo,
                                    contentColor = blackColor
                                )
                            ) {
                                Text("Study Plans", fontSize = 16.sp, textAlign = TextAlign.Center)
                            }

                            Button(
                                onClick = { navController.navigate("study_progress") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp),
                                shape = RoundedCornerShape(60.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = naranjitafondo,
                                    contentColor = blackColor
                                )
                            ) {
                                Text("Progress", fontSize = 16.sp, textAlign = TextAlign.Center)
                            }

                            Button(
                                onClick = { navController.navigate("offline_mode") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp),
                                shape = RoundedCornerShape(60.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = naranjitafondo,
                                    contentColor = blackColor
                                )
                            ) {
                                Text("Offline", fontSize = 16.sp, textAlign = TextAlign.Center)
                            }
                        } 