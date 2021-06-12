package com.example.appstarwars.Service.Local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/*class Database {

    @Database(entities = [PersonModel::class], version = 1)
    abstract class Database : RoomDatabase() {

        companion object {
            private lateinit var INSTANCE: Database

            fun getDatabase(context: Context): Database {
                if (!Companion::INSTANCE.isInitialized) {
                    synchronized(Database::class) {
                        INSTANCE = Room.databaseBuilder(context, Database::class.java, "tasksDB")
                            .allowMainThreadQueries()
                            .build()
                    }
                }
                return INSTANCE
            }
        }

    }
}*/