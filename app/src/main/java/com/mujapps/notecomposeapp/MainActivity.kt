package com.mujapps.notecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.mujapps.notecomposeapp.data.NotesDataSource
import com.mujapps.notecomposeapp.model.Note
import com.mujapps.notecomposeapp.screen.NoteScreen
import com.mujapps.notecomposeapp.screen.NotesScreenViewModel
import com.mujapps.notecomposeapp.ui.theme.NoteComposeAppTheme

class MainActivity : ComponentActivity() {
    private val mNoteVewModel: NotesScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesApp {
                val mNotes = mNoteVewModel.getAllNotes()

                NoteScreen(notes = mNotes,
                    onAddNote = {
                        mNoteVewModel.addNewNote(it)
                    },
                    onRemoveNote = {
                        mNoteVewModel.removeNote(it)
                    })
            }
        }
    }
}

@Composable
fun NotesApp(content: @Composable () -> Unit) {
    content()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    /*NotesApp {

    }*/
}