package com.mujapps.notecomposeapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.mujapps.notecomposeapp.data.NotesDataSource
import com.mujapps.notecomposeapp.model.Note

class NotesScreenViewModel : ViewModel() {

    private var mNoteList = mutableStateListOf<Note>()

    init {
        mNoteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNewNote(note: Note) {
        mNoteList.add(note)
    }

    fun removeNote(note: Note) {
        mNoteList.remove(note)
    }

    fun getAllNotes(): List<Note> = mNoteList
}