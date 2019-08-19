package com.abid.note.database.room

import android.arch.persistence.room.*
import com.abid.note.database.base.BaseDataProvider
import com.abid.note.ui.models.Note
import com.abid.note.ui.models.Notebook
import com.abid.note.ui.models.Tag

@Dao
interface RoomDao {
    @Query("Select * From Note")
    fun getAllNotes(): List<Note>

    @Query("Select * From Notebook")
    fun getAllNotebooks(): List<Notebook>

    @Query("Select * From Tag")
    fun getAllTags(): List<Tag>

    @Insert
    fun addNote(note: Note)

    @Update
    fun updatNote(note: Note)

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

    @Query("Select * from Note as n where n.id=:noteId")
    fun getNoteById(noteId: Long): Note
}