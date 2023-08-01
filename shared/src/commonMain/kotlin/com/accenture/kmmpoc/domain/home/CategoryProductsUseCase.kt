package com.accenture.kmmpoc.domain.home

import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.domain.base.UseCaseWithParams
import com.accenture.kmmpoc.domain.home.entity.Category
import com.accenture.kmmpoc.domain.home.entity.CategoryProducts

class CategoryProductsUseCase(
    private val repository: ProductsRepository
): UseCaseWithParams<Category, CategoryProducts> {

    override suspend fun execute(params: Category): DomainResponse<CategoryProducts> {
        return repository.getProductsByCategory(params)
    }
}