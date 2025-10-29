package com.example.starter

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.starter.model.Bird
import com.example.starter.model.Cat
import com.example.starter.model.Dinosaur
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class App : Application() {
    companion object {
        lateinit var app: App
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        app = this

        val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                //Pre-load the db with default tables for example purposes
                CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
                    App.db.catDao().insertAll(*catTable)
                    App.db.dinosaurDao().insertAll(*dinosaurTable)
                    App.db.birdDao().insertAll(*birdTable)
                }
            }
        }

        db = Room.databaseBuilder(
            context = app,
            klass = AppDatabase::class.java,
            name = "petsDb"
        ).addCallback(roomCallback).build()
    }

    private val dinosaurTable = arrayOf(
        Dinosaur("Tyrannosaurus Rex"),
        Dinosaur("Triceratops"),
        Dinosaur("Velociraptor"),
        Dinosaur("Stegosaurus"),
        Dinosaur("Brachiosaurus"),
        Dinosaur("Ankylosaurus"),
        Dinosaur("Allosaurus"),
        Dinosaur("Diplodocus"),
        Dinosaur("Iguanodon"),
        Dinosaur("Spinosaurus")
    )

    private val catTable = arrayOf(
        Cat("Persian"),
        Cat("Siamese"),
        Cat("Maine Coon"),
        Cat("Bengal"),
        Cat("Sphynx"),
        Cat("Ragdoll"),
        Cat("Scottish Fold"),
        Cat("British Shorthair"),
        Cat("American Shorthair"),
        Cat("Himalayan")
    )

    private val birdTable = arrayOf(
        Bird("Parrot"),
        Bird("Sparrow"),
        Bird("Eagle"),
        Bird("Canary"),
        Bird("Pigeon"),
        Bird("Hawk"),
        Bird("Flamingo"),
        Bird("Ostrich"),
        Bird("Penguin"),
        Bird("Peacock")
    )
}