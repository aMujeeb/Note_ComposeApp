package com.mujapps.notecomposeapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mujapps.notecomposeapp.data.NotesDataSource
import com.mujapps.notecomposeapp.model.Note
import com.mujapps.notecomposeapp.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesScreenViewModel @Inject constructor(
    private val mRepository: NotesRepository
) : ViewModel() {

    //private var mNoteList = mutableStateListOf<Note>()

    private val _notList = MutableStateFlow<List<Note>>(emptyList())
    val mNoteList = _notList.asStateFlow()

    init {
        //mNoteList.addAll(NotesDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.getAllNotes().distinctUntilChanged().collect { notes ->
                if (!notes.isNullOrEmpty()) {
                    _notList.value = notes
                } else {

                }
            }
        }
    }

    fun addNewNote(note: Note) = viewModelScope.launch {
        mRepository.addNote(note)
    }

    fun removeNote(note: Note) = viewModelScope.launch {
        mRepository.deleteNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        mRepository.updateNote(note)
    }
}