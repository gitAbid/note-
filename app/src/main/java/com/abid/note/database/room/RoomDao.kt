package com.abid.note.database.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.abid.note.database.base.BaseDataProvider
import com.abid.note.ui.models.Note
import com.abid.note.ui.models.Notebook
import com.abid.note.ui.models.Tag

@Dao
interface RoomDao  {
    @Query("Select * From Note")
    fun getAllNotes(): List<Note>

    @Query("Select * From Notebook")
    fun getAllNotebooks(): List<Notebook>

    @Query("Select * From Tag")
    fun getAllTags(): List<Tag>

    @Insert
    fun addNote(note: Note)

    @Insert
    fun addNotebook(notebook: Notebook)

    @Insert
    fun addTag(tag: Tag)

    @Delete
    fun deleteNote(note: Note)

    @Delete
    fun deleteNotebook(notebook: Notebook)

    @Delete
    fun deleteTag(tag: Tag)
}