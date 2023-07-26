package com.accenture.kmmpoc.data.auth.entity

import com.accenture.kmmpoc.domain.auth.entity.UserProfile
import com.accenture.kmmpoc.domain.auth.entity.UserSession
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    @SerialName("id") val userID: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    @SerialName("image") val imageURL: String,
    val token: String
)

internal fun SignInResponse.toDomainEntity() = UserSession(
    token = this.token,
    userProfile = UserProfile(
        userID = this.userID,
        username = this.username,
        email = this.email,
        firstName = this.firstName,
        lastName = this.lastName,
        gender = this.gender,
        imageURL = this.imageURL
    )
)
