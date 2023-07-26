package com.accenture.kmmpoc.data.auth.entity

import com.accenture.kmmpoc.domain.auth.entity.SignInData
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.EncodeDefault.Mode.NEVER
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

const val NO_EXPIRY = -1

@Serializable
data class SignInRequestBody @OptIn(ExperimentalSerializationApi::class) constructor(
    val username: String,
    val password: String,
    @EncodeDefault(NEVER) val expiresInMins: Int = NO_EXPIRY
)

fun SignInData.toRequestBody(
    expiresInMins: Int = NO_EXPIRY
) = SignInRequestBody(
    username = this.username,
    password = this.password,
    expiresInMins = expiresInMins
)
