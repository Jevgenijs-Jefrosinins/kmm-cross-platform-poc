package com.accenture.kmmpoc.domain.home.entity

data class CategoryProducts(
    val products: List<ProductInfo>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
