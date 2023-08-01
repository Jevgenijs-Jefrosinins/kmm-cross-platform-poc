package com.accenture.kmmpoc.domain.home

import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.domain.base.UseCaseWithParams
import com.accenture.kmmpoc.domain.home.entity.Product
import com.accenture.kmmpoc.domain.home.entity.ProductInfo

class ProductDetailsUseCase(
    private val repository: ProductsRepository
): UseCaseWithParams<ProductInfo, Product> {

    override suspend fun execute(params: ProductInfo): DomainResponse<Product> {
        return repository.getProductDetails(params)
    }
}