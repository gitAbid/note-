package com.abid.note.database.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.abid.note.ui.models.*

@Database(
    entities = arrayOf(Note::class, Notebook::class, Tag::class, RelationalNotebook::class, RelationalTag::class),
    version = 1
)
abstract class RoomDB : RoomDatabase() {
    abstract fun roomDao(): RoomDao
}