package com.example.starter

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.starter.model.Bird
import com.example.starter.model.BirdDao
import com.example.starter.model.Cat
import com.example.starter.model.CatDao
import com.example.starter.model.Dinosaur
import com.example.starter.model.DinosaurDao

@Database(entities = [Bird::class, Dinosaur::class, Cat::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun birdDao(): BirdDao
    abstract fun dinosaurDao(): DinosaurDao
    abstract fun catDao(): CatDao
}