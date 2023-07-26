package com.accenture.kmmpoc.domain.base

interface UseCase<out T : Any> {
    suspend fun execute(): DomainResponse<T>
}
