package com.mujapps.notecomposeapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mujapps.notecomposeapp.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(DateConverter::class)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}