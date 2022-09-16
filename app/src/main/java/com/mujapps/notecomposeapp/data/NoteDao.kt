package com.mujapps.notecomposeapp.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.mujapps.notecomposeapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id =:id")
    suspend fun getNoteById(id: String) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteNote(note: Note)
}