package com.mujapps.notecomposeapp.di

import android.content.Context
import androidx.room.Room
import com.mujapps.notecomposeapp.data.NoteDao
import com.mujapps.notecomposeapp.data.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesNoteDao(noteDataBase: NoteDataBase): NoteDao = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): NoteDataBase =
        Room.databaseBuilder(context, NoteDataBase::class.java, "note_db")
            .fallbackToDestructiveMigration().build()
}