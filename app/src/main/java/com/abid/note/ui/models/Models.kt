package com.abid.note.ui.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Abid Hasan on 6/9/19.
 * Copyright (c) 2019. All rights reserved.
 * @author Abid Hasan
 *
 */

@Entity
data class Notebook(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "title") var title: String
)

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "body") var body: String
){
    companion object{
        const val ID="id"
    }
}

@Entity
data class Tag(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "name") var name: String
)

@Entity
data class RelationalTag(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "note") var note: Long,
    @ColumnInfo(name = "tag") var tag: Long
)

@Entity
data class RelationalNotebook(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "notebook") var notebook: Long,
    @ColumnInfo(name = "note") var note: Long
)