package com.abid.note.ui.notes.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.abid.note.R
import com.abid.note.listeners.NoteItemListener
import com.abid.note.listeners.NotebookNavigationListener
import com.abid.note.ui.models.Note
import com.abid.note.ui.models.Notebook
import com.abid.note.ui.notes.adapter.NoteAdapter
import com.abid.note.ui.notes.adapter.NotebookAdapter
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment(), NotebookNavigationListener, NoteItemListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,"
        notebookRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = NotebookAdapter(
                listOf(
                    Notebook("Add Notebook", 1, listOf(1, 2)),
                    Notebook("TO-DO", 1, listOf(1, 2)),
                    Notebook("Physics", 1, listOf(1, 2)),
                    Notebook("Chemistry", 1, listOf(1, 2)),
                    Notebook("Biology", 1, listOf(1, 2)),
                    Notebook("Mathematics", 1, listOf(1, 2))
                ), naviation = this@NotesFragment
            )

        }

        rcvNotes.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = NoteAdapter(
                listOf(
                    Note(1, "What is Lorem Ipsum?", text, listOf(1, 2)),
                    Note(1, "Why do we use it?", text, listOf(1, 2)),
                    Note(1, "Where does it come from?", text, listOf(1, 2)),
                    Note(1, "Where can I get some?", text, listOf(1, 2))
                    /* Note(1, "This is an demo note text Title", text, listOf(1,2)),
                     Note(1, "This is an demo note text Title", text, listOf(1,2)),
                     Note(1, "This is an demo note text Title", text, listOf(1,2))*/
                ),
                this@NotesFragment
            )

        }
    }

    override fun onAddNotebookClicked() {
        Toast.makeText(context, "Add Item Clicked", Toast.LENGTH_SHORT).show()
        NavHostFragment.findNavController(this).navigate(R.id.ac_new_notebook)
    }

    override fun onNotebookItemClicked(view: View, positon: Int) {
        Toast.makeText(context, "Notebook Item Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.ac_note_details)
    }

}
