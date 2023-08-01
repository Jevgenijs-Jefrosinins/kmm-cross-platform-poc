package com.accenture.kmmpoc.data.home.entity

import com.accenture.kmmpoc.domain.home.entity.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("id") val productID: Int,
    val title: String,
    val description: String,
    val rating: Float,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)

internal fun ProductResponse.toDomainEntity() = Product(
    id = productID,
    title = title,
    description = description,
    rating = rating,
    brand = brand,
    category = category,
    thumbnail = thumbnail,
    images = images
)