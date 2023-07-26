package com.accenture.kmmpoc.domain.auth

import com.accenture.kmmpoc.domain.auth.entity.SignInData
import com.accenture.kmmpoc.domain.auth.entity.UserSession
import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.domain.base.UseCaseWithParams

class SignInUseCase(
    private val repository: AuthRepository
): UseCaseWithParams<SignInData, UserSession> {

    override suspend fun execute(params: SignInData): DomainResponse<UserSession> {
        return repository.signIn(params)
    }
}
