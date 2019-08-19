package com.abid.note.ui.notes.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abid.note.R
import com.abid.note.listeners.NoteItemListener
import com.abid.note.ui.models.Note
import kotlinx.android.synthetic.main.item_notebook.view.tvNotebookTitle
import kotlinx.android.synthetic.main.item_notes.view.*

/**
 * Created by Abid Hasan on 6/9/19.
 * Copyright (c) 2019. All rights reserved.
 * @author Abid Hasan
 *
 */

class NoteAdapter(var items: List<Note>, var itemListener: NoteItemListener) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    lateinit var context: Context

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        viewholder.notebookTitle?.text = "${items.get(position).id} . ${items.get(position).title}"
        viewholder.notebookDescription?.text = items.get(position).body
        viewholder.noteItem?.setOnClickListener {
            itemListener.onItemClickListener(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(viewholder: ViewGroup, position: Int): ViewHolder {
        context = viewholder.context
        return ViewHolder(
            LayoutInflater.from(viewholder.context).inflate(
                R.layout.item_notes,
                viewholder,
                false
            )
        )

    }

    fun update(notes: List<Note>) {
        items = notes
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noteItem = view.llNoteItem
        val notebookTitle = view.tvNotebookTitle
        val notebookDescription = view.tvNotebookDescription
    }
}

