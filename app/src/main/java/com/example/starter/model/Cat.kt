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
class Cat(
    @ColumnInfo val name: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)

@Dao
interface CatDao {
    @Query("SELECT * FROM cat")
    suspend fun getAll(): List<Cat>

    @Query("SELECT * FROM cat WHERE name LIKE :name LIMIT 1")
    suspend fun findByName(name: String): Cat

    @Insert
    suspend fun insertAll(vararg cats: Cat)

    @Delete
    suspend fun delete(cat: Cat)
}