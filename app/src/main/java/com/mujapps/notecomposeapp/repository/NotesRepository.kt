package com.mujapps.notecomposeapp.repository

import com.mujapps.notecomposeapp.data.NoteDao
import com.mujapps.notecomposeapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NotesRepository @Inject constructor(private val notesDao: NoteDao) {

    suspend fun addNote(note: Note) = notesDao.addNewNote(note)
    suspend fun updateNote(note: Note) = notesDao.updateNote(note)
    suspend fun deleteNote(note: Note) = notesDao.deleteNote(note)
    suspend fun deleteAllNotes() = notesDao.deleteAllNotes()
    suspend fun getAllNotes(): Flow<List<Note>> = notesDao.getAllNotes().flowOn(Dispatchers.IO)
}