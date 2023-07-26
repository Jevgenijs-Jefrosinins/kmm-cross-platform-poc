package com.accenture.kmmpoc.data.auth

import com.accenture.kmmpoc.data.auth.entity.toDomainEntity
import com.accenture.kmmpoc.data.auth.entity.toRequestBody
import com.accenture.kmmpoc.domain.auth.entity.SignInData
import com.accenture.kmmpoc.domain.auth.entity.UserSession

class AuthApiDataSource(
    private val apiService: AuthApiService
) {

    suspend fun signIn(params: SignInData): UserSession {
        return apiService.signIn(
            params.toRequestBody()
        ).toDomainEntity()
    }
}
