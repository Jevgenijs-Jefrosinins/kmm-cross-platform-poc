package com.accenture.kmmpoc.data.auth

import com.accenture.kmmpoc.domain.auth.AuthRepository
import com.accenture.kmmpoc.domain.auth.entity.SignInData
import com.accenture.kmmpoc.domain.auth.entity.UserSession
import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.domain.base.domainResponse

class AuthRepositoryImpl(
    private val apiDataSource: AuthApiDataSource
): AuthRepository {

    override suspend fun signIn(signInData: SignInData): DomainResponse<UserSession> {
        return domainResponse {
            apiDataSource.signIn(signInData)
        }
    }
}
