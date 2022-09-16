package com.mujapps.notecomposeapp.model

import androidx.room.*
import com.mujapps.notecomposeapp.data.DateConverter
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,

    @ColumnInfo(name = "note_entryDate")
    @TypeConverters(DateConverter::class)
    val entryDate: Date = Date.from(Instant.now())
)
