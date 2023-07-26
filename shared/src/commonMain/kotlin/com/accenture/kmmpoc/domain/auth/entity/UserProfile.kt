package com.accenture.kmmpoc.domain.auth.entity

data class UserProfile(
    val userID: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val imageURL: String
)
