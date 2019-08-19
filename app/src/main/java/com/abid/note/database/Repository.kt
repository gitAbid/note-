package com.abid.note.database


import android.arch.persistence.room.Room
import android.content.Context
import com.abid.note.database.base.BaseDataProvider
import com.abid.note.database.room.RoomDB
import com.abid.note.ui.models.Note
import com.abid.note.ui.models.Notebook
import com.abid.note.ui.models.Tag

class Repository(var context: Context, var db: String) : BaseDataProvider {
    override fun addNote(note: Note) {
        roomDB.roomDao().addNote(note)
    }

    init {
        getDB()
    }

    override fun addNotebook(notebook: Notebook) {
        roomDB.roomDao().addNotebook(notebook)
    }

    override fun addTag(tag: Tag) {
        roomDB.roomDao().addTag(tag)
    }

    override fun deleteNoteById(id: Long) {
    }

    override fun deleteNotebookById(id: Long) {
    }

    override fun deleteTagById(id: Long) {
    }

    override fun deleteNote(note: Note) {
    }

    override fun deleteNotebook(notebook: Notebook) {
    }

    override fun deleteTag(tag: Tag) {
    }

    companion object {
        public val ROOM_DB = "room"
    }

    lateinit var roomDB: RoomDB

    override fun getAllNotebooks(): List<Notebook> {
        return roomDB.roomDao().getAllNotebooks()
    }

    override fun getAllTags(): List<Tag> {
        return roomDB.roomDao().getAllTags()
    }

    override fun getAllNotes(): List<Note> {
        return roomDB.roomDao().getAllNotes()
    }

    fun getDB(): RoomDB {
        roomDB = Room.databaseBuilder(
            context,
            RoomDB::class.java, "note-room-db"
        ).fallbackToDestructiveMigration().build()

        return roomDB
    }


}