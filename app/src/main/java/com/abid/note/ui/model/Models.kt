package com.abid.note.ui.model

/**
 * Created by Abid Hasan on 6/9/19.
 * Copyright (c) 2019. All rights reserved.
 * @author Abid Hasan
 *
 */

data class NotebookModel(var title: String, var id: Long, var notes: List<Long>)
data class NoteModel(var id: Long, var title: String, var description: String, var tag: List<Long>)
data class TagModel(var id: Long, var name: String)