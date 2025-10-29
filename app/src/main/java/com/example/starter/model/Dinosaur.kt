package com.example.starter.model

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

//A model (MVVM Design Pattern) represents the data and business logic of the application.
@Entity
class Dinosaur(
    @ColumnInfo val name: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)

@Dao
interface DinosaurDao {
    @Query("SELECT * FROM dinosaur")
    suspend fun getAll(): List<Dinosaur>

    @Query("SELECT * FROM dinosaur WHERE name LIKE :name LIMIT 1")
    suspend fun findByName(name: String): Dinosaur

    @Insert
    suspend fun insertAll(vararg dinosaurs: Dinosaur)

    @Delete
    suspend fun delete(dinosaur: Dinosaur)
}