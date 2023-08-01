package com.accenture.kmmpoc.data.home

import com.accenture.kmmpoc.data.home.entity.toDomainEntity
import com.accenture.kmmpoc.domain.home.entity.Category
import com.accenture.kmmpoc.domain.home.entity.CategoryProducts
import com.accenture.kmmpoc.domain.home.entity.Product
import com.accenture.kmmpoc.domain.home.entity.ProductInfo

class ProductsApiDataSource(
    private val apiService: ProductsApiService
) {

    suspend fun getCategories(): List<Category> {
        return apiService.getCategories().toDomainEntity()
    }

    suspend fun getProductsByCategory(category: Category): CategoryProducts {
        return apiService.getProductsByCategory(category.name).toDomainEntity()
    }

    suspend fun getProductDetails(productInfo: ProductInfo): Product {
        return apiService.getProductDetails(productInfo.id).toDomainEntity()
    }

}