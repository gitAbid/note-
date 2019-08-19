package com.abid.note.database.base
import com.abid.note.ui.models.Note
import com.abid.note.ui.models.Notebook
import com.abid.note.ui.models.Tag

interface BaseDataProvider {
    fun getAllNotes(): List<Note>
    fun getAllNotebooks(): List<Notebook>
    fun getAllTags(): List<Tag>

    fun addNote(note:Note)
    fun addNotebook(notebook:Notebook)
    fun addTag(tag:Tag)


    fun deleteNoteById(id:Long)
    fun deleteNotebookById(id:Long)
    fun deleteTagById(id:Long)

    fun deleteNote(note:Note)
    fun deleteNotebook(notebook:Notebook)
    fun deleteTag(tag:Tag)
}