package com.accenture.kmmpoc.data.home.entity

import com.accenture.kmmpoc.domain.home.entity.CategoryProducts

@kotlinx.serialization.Serializable
data class CategoryProductsResponse(
    val products: List<ProductItemResponse>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

internal fun CategoryProductsResponse.toDomainEntity() = CategoryProducts(
    products = products.map {it.toDomainEntity()},
    total = total,
    skip = skip,
    limit = limit
)
