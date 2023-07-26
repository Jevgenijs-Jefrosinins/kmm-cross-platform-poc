package com.accenture.kmmpoc.domain.base

interface UseCaseWithParams<P, out T : Any> {
    suspend fun execute(params: P): DomainResponse<T>
}