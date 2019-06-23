package com.abid.note.application

import android.app.Application
import android.arch.persistence.room.Room
import com.abid.note.database.Repository
import com.abid.note.database.room.RoomDB

class NoteApplication : Application() {

    companion object {
        private lateinit var roomDB: RoomDB

    }

    override fun onCreate() {
        super.onCreate()
    }


}