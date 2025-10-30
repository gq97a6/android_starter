package com.example.starter.repository

import com.example.starter.App
import com.example.starter.AppDatabase

//A model (MVVM Design Pattern) represents the data and business logic of the application.
//A repository (Repository Design Pattern) provides data to the rest of the application
//typically by abstracting the data sources like network or local database.

object CatsRepository {
    suspend fun getAllCats(db: AppDatabase = App.db) = db.catDao().getAll()
}