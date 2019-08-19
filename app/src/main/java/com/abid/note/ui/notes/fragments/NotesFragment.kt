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
import com.abid.note.application.NoteApplication
import com.abid.note.container.MainActivity
import com.abid.note.database.room.RoomDB
import com.abid.note.listeners.NoteItemListener
import com.abid.note.listeners.NotebookNavigationListener
import com.abid.note.ui.models.Note
import com.abid.note.ui.notes.adapter.NoteAdapter
import com.abid.note.ui.notes.adapter.NotebookAdapter
import kotlinx.android.synthetic.main.fragment_notes.*
import kotlinx.coroutines.*

class NotesFragment : Fragment(), NotebookNavigationListener, NoteItemListener {

    private lateinit var noteAdapter: NoteAdapter
    private var notes: List<Note>
    private lateinit var db: RoomDB
    private var UIScope: CoroutineScope

    init {
        notes = listOf()
        UIScope = CoroutineScope(Dispatchers.Default)
    }

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
            adapter = NotebookAdapter(listOf(), naviation = this@NotesFragment)

        }
        noteAdapter = NoteAdapter(notes, this@NotesFragment);
        rcvNotes.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = noteAdapter
        }

        fabAddNote.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.ac_note_details).apply {
            }
            // val note = Note(title = "New Title", body = text)
            //addNewNote(note)
        }

    }

    override fun onResume() {
        super.onResume()
        updateAllNotes()
    }

    fun updateAllNotes() {
        UIScope.launch {
            withContext(Dispatchers.IO) {
                notes = db.roomDao().getAllNotes()
            }
            noteAdapter.update(notes)
        }
    }

    fun addNewNote(note: Note) {
        UIScope.launch {
            withContext(Dispatchers.IO) { db.roomDao().addNote(note) }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = NoteApplication.roomDB


    }


    override fun onAddNotebookClicked() {
        Toast.makeText(context, "Add Item Clicked", Toast.LENGTH_SHORT).show()
        NavHostFragment.findNavController(this).navigate(R.id.ac_new_notebook)
    }

    override fun onNotebookItemClicked(view: View, positon: Int) {
        Toast.makeText(context, "Notebook Item Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(position: Int) {
        var bundle = Bundle()
        bundle.putLong(Note.ID, noteAdapter.items.get(position).id)
        NavHostFragment.findNavController(this).navigate(R.id.ac_note_details,bundle)
    }

}
