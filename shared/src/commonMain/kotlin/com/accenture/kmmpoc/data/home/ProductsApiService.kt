package com.accenture.kmmpoc.data.home

import com.accenture.kmmpoc.data.base.BaseApiService
import com.accenture.kmmpoc.data.base.Endpoint
import com.accenture.kmmpoc.data.base.Environment
import com.accenture.kmmpoc.data.home.entity.CategoriesResponse
import com.accenture.kmmpoc.data.home.entity.CategoryProductsResponse
import com.accenture.kmmpoc.data.home.entity.ProductResponse
import io.ktor.client.HttpClient
import io.ktor.http.appendPathSegments

class ProductsApiService(
    httpClient: HttpClient,
    environment: Environment
): BaseApiService(httpClient, environment) {

    suspend fun getCategories(): CategoriesResponse {
        val categoryNames = get<List<String>>(
            endpoint = Endpoint.Categories
        )
        return CategoriesResponse(categoryNames)
    }

    suspend fun getProductsByCategory(categoryName: String): CategoryProductsResponse = get(
        endpoint = Endpoint.ProductsByCategory
    ) {
        this.url.appendPathSegments(categoryName)
    }

    suspend fun getProductDetails(productID: Int): ProductResponse = get(
        endpoint = Endpoint.Details
    ) {
        this.url.appendPathSegments(productID.toString())
    }
}