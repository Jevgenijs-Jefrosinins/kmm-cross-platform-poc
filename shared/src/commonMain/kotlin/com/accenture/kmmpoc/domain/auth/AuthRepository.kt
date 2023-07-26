package com.accenture.kmmpoc.domain.auth

import com.accenture.kmmpoc.domain.auth.entity.SignInData
import com.accenture.kmmpoc.domain.auth.entity.UserSession
import com.accenture.kmmpoc.domain.base.DomainResponse

interface AuthRepository {
    suspend fun signIn(signInData: SignInData): DomainResponse<UserSession>
}
