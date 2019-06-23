package com.abid.note.ui.notes.fragments


import android.arch.persistence.room.Room
import android.content.Context
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
import com.abid.note.database.room.RoomDB
import com.abid.note.listeners.NoteItemListener
import com.abid.note.listeners.NotebookNavigationListener
import com.abid.note.ui.notes.adapter.NoteAdapter
import com.abid.note.ui.notes.adapter.NotebookAdapter
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment(), NotebookNavigationListener, NoteItemListener {

    private lateinit var db: RoomDB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDate()
        val text =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,"
        notebookRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = NotebookAdapter(
                listOf(
                ), naviation = this@NotesFragment
            )

        }

        rcvNotes.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = NoteAdapter(
                listOf(
                ),
                this@NotesFragment
            )

        }
    }

    private fun initDate() {


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = getDB()

    }

    fun getDB(): RoomDB {
        return Room.databaseBuilder(
            activity as Context,
            RoomDB::class.java, "note-room-db"
        )
            .fallbackToDestructiveMigration().build()
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
