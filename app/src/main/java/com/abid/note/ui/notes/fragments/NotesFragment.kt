package com.abid.note.ui.notes.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abid.note.R
import com.abid.note.ui.model.NotebookModel
import com.abid.note.ui.notes.adapter.NotebookAdapter
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notebookRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = NotebookAdapter(
                listOf(
                    NotebookModel("Add Notebook", 1, listOf(1, 2)),
                    NotebookModel("TO-DO", 1, listOf(1, 2)),
                    NotebookModel("Physics", 1, listOf(1, 2)),
                    NotebookModel("Chemistry", 1, listOf(1, 2)),
                    NotebookModel("Biology", 1, listOf(1, 2)),
                    NotebookModel("Mathematics", 1, listOf(1, 2))
                )
            )

        }
    }

}
