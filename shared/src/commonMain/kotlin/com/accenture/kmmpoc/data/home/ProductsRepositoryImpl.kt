package com.accenture.kmmpoc.data.home

import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.domain.base.domainResponse
import com.accenture.kmmpoc.domain.home.ProductsRepository
import com.accenture.kmmpoc.domain.home.entity.Category
import com.accenture.kmmpoc.domain.home.entity.CategoryProducts
import com.accenture.kmmpoc.domain.home.entity.Product
import com.accenture.kmmpoc.domain.home.entity.ProductInfo

class ProductsRepositoryImpl(
    private val apiDataSource: ProductsApiDataSource
): ProductsRepository {

    override suspend fun getCategories(): DomainResponse<List<Category>> {
        return domainResponse {
            apiDataSource.getCategories()
        }
    }

    override suspend fun getProductsByCategory(category: Category): DomainResponse<CategoryProducts> {
        return domainResponse {
            apiDataSource.getProductsByCategory(category)
        }
    }

    override suspend fun getProductDetails(productInfo: ProductInfo): DomainResponse<Product> {
        return domainResponse {
            apiDataSource.getProductDetails(productInfo)
        }
    }
}