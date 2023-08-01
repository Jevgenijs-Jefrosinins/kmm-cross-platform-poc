package com.accenture.kmmpoc.domain.home

import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.domain.home.entity.Category
import com.accenture.kmmpoc.domain.home.entity.CategoryProducts
import com.accenture.kmmpoc.domain.home.entity.Product
import com.accenture.kmmpoc.domain.home.entity.ProductInfo

interface ProductsRepository {

    suspend fun getCategories(): DomainResponse<List<Category>>

    suspend fun getProductsByCategory(category: Category): DomainResponse<CategoryProducts>

    suspend fun getProductDetails(productInfo: ProductInfo): DomainResponse<Product>

}
