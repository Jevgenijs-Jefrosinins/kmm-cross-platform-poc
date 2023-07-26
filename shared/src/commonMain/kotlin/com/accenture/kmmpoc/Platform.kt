package com.accenture.kmmpoc

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform