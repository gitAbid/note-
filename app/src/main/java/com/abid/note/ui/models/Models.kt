package com.abid.note.ui.models

/**
 * Created by Abid Hasan on 6/9/19.
 * Copyright (c) 2019. All rights reserved.
 * @author Abid Hasan
 *
 */

data class Notebook(var title: String, var id: Long, var notes: List<Long>)
data class Note(var id: Long, var title: String, var description: String, var tag: List<Long>)
data class Tag(var id: Long, var name: String)