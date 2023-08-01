package com.accenture.kmmpoc.data.home.entity

import com.accenture.kmmpoc.domain.home.entity.Category

data class CategoriesResponse(
    val categoryNames: List<String>
)

internal fun CategoriesResponse.toDomainEntity(): List<Category> =
    categoryNames.map { Category(it) }
