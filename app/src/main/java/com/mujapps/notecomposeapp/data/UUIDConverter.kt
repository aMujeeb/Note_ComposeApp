package com.mujapps.notecomposeapp.data

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {
    @TypeConverter
    fun fromUUID(uuid: UUID): String? {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
}