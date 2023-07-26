package com.accenture.kmmpoc.domain.auth.entity

data class UserSession(
    val token: String,
    val userProfile: UserProfile
)