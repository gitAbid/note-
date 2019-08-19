package com.abid.note.application

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.abid.note.database.Repository
import com.abid.note.database.room.RoomDB

class NoteApplication : Application() {
    companion object {
        public lateinit var roomDB: RoomDB

    }

    override fun onCreate() {
        super.onCreate()
        roomDB = Room.databaseBuilder(
            this as Context,
            RoomDB::class.java, "note-room-db"
        ).fallbackToDestructiveMigration().build()
    }


}