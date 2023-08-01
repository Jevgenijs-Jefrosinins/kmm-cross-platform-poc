package com.accenture.kmmpoc.data.home.entity

import com.accenture.kmmpoc.domain.home.entity.ProductInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductItemResponse(
    @SerialName("id") val productID: Int,
    val title: String,
    val description: String,
    val rating: Float,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)

internal fun ProductItemResponse.toDomainEntity() = ProductInfo(
    id = productID,
    title = title,
    category = category,
    thumbnail = thumbnail,
)