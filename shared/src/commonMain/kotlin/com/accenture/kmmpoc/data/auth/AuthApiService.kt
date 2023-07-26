package com.accenture.kmmpoc.data.auth

import com.accenture.kmmpoc.data.auth.entity.SignInRequestBody
import com.accenture.kmmpoc.data.auth.entity.SignInResponse
import com.accenture.kmmpoc.data.base.BaseApiService
import com.accenture.kmmpoc.data.base.Endpoint
import com.accenture.kmmpoc.data.base.Environment
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

const val CONTENT_TYPE_JSON = "application/json"

class AuthApiService(
    httpClient: HttpClient,
    environment: Environment
): BaseApiService(httpClient, environment) {

    suspend fun signIn(requestBody: SignInRequestBody): SignInResponse = post(
        endpoint = Endpoint.SignIn
    ) {
        headers {
            append(HttpHeaders.ContentType, CONTENT_TYPE_JSON)
        }
        setBody(requestBody)
    }
}