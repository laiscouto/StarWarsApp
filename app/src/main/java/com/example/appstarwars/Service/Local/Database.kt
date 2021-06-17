package com.example.appstarwars.Service.Local

import android.content.Context
import android.content.Entity
import androidx.room.Room
import androidx.room.RoomDatabase


/*abstract class Database : RoomDatabase(){

    abstract fun personDAO() : PersonDAO

    companion object {
        private lateinit var INSTANCE: Database

            fun getDatabase(context: Context): Database {
                if (!Companion::INSTANCE.isInitialized) {
                    synchronized(Database::class) {
                        INSTANCE = Room.databaseBuilder(context, Database::class.java, "StarWarsDB")
                            .allowMainThreadQueries()
                            .build()
                    }
                }
                return INSTANCE
            }
    }
}*/