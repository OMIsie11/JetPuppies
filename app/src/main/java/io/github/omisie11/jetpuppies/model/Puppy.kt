package io.github.omisie11.jetpuppies.model

data class Puppy(
    val name: String,
    val breed: String,
    val mainPhoto: Int,
    val allPhotos: List<Int>,
    val bio: String,
)
