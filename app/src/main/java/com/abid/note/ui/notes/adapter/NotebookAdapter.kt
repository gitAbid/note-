package com.abid.note.ui.notes.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.abid.note.R
import com.abid.note.listeners.NotebookNavigationListener
import com.abid.note.ui.model.NotebookModel
import kotlinx.android.synthetic.main.item_add_notebook.view.*
import kotlinx.android.synthetic.main.item_notebook.view.*

/**
 * Created by Abid Hasan on 6/9/19.
 * Copyright (c) 2019. All rights reserved.
 * @author Abid Hasan
 *
 */

class NotebookAdapter(var items: List<NotebookModel>, var naviation: NotebookNavigationListener) :
    RecyclerView.Adapter<NotebookAdapter.ViewHolder>() {

    private val FIRST_INDEX: Int = 0
    lateinit var context: Context

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {

        if (position == FIRST_INDEX) {
            viewholder.addNotebook?.setOnClickListener {
                naviation.onAddNotebookClicked()
            }
        } else {
            viewholder.notebookTitle?.text = items[position].title
            viewholder.notbookItem?.setOnClickListener {
                naviation.onNotebookItemClicked(it,position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(viewholder: ViewGroup, position: Int): ViewHolder {
        context = viewholder.context
        if (position == FIRST_INDEX) {
            return ViewHolder(
                LayoutInflater.from(viewholder.context).inflate(
                    R.layout.item_add_notebook,
                    viewholder,
                    false
                )
            )
        } else {
            return ViewHolder(
                LayoutInflater.from(viewholder.context).inflate(
                    R.layout.item_notebook,
                    viewholder,
                    false
                )
            )
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val addNotebook = view.ivAddNotebook
        val notbookItem = view.llNotebookItem
        val notebookTitle = view.tvNotebookTitle
    }
}

