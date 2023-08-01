package com.accenture.kmmpoc.domain.home.entity

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Float,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)
