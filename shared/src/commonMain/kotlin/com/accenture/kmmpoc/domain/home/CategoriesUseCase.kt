package com.accenture.kmmpoc.domain.home

import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.domain.base.UseCase
import com.accenture.kmmpoc.domain.home.entity.Category

class CategoriesUseCase(
    private val repository: ProductsRepository
): UseCase<List<Category>> {

    override suspend fun execute(): DomainResponse<List<Category>> {
        return repository.getCategories()
    }
}