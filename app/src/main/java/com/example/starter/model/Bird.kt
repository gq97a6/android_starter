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
data class Bird(
    @ColumnInfo val name: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)

@Dao
interface BirdDao {
    @Query("SELECT * FROM bird")
    suspend fun getAll(): List<Bird>

    @Query("SELECT * FROM bird WHERE name LIKE :name LIMIT 1")
    suspend fun findByName(name: String): Bird

    @Insert
    suspend fun insertAll(vararg birds: Bird)

    @Delete
    suspend fun delete(bird: Bird)
}