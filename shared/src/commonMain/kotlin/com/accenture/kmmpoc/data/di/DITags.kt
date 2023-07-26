package com.accenture.kmmpoc.data.di

//DI tags can be used to provide tagged bindings. E.g. to differentiate 2 instances
// of ContextWrapper (for Android) - 'application context' and 'activity context'
// or 2 instances of same UseCase if they are created using different constructor params

const val app = "application"
const val appContext = "applicationContext"
const val dbName = "databaseFileName"