package com.accenture.kmmpoc.domain.di

import com.accenture.kmmpoc.domain.auth.SignInUseCase
import com.accenture.kmmpoc.domain.home.CategoriesUseCase
import com.accenture.kmmpoc.domain.home.CategoryProductsUseCase
import com.accenture.kmmpoc.domain.home.ProductDetailsUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val useCaseModule = DI.Module("UseCaseModule") {
    //TODO for Android - dependency modules should be imported in application class

    bind<SignInUseCase>() with provider { SignInUseCase(instance()) }

    bind<CategoriesUseCase>() with provider { CategoriesUseCase(instance()) }
    bind<CategoryProductsUseCase>() with provider { CategoryProductsUseCase(instance()) }
    bind<ProductDetailsUseCase>() with provider { ProductDetailsUseCase(instance()) }
}