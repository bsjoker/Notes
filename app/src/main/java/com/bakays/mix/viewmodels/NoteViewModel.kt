package com.bakays.mix.viewmodels

import androidx.lifecycle.ViewModel
import com.bakays.mix.models.NoteModel
import com.bakays.mix.database.NotesRepo
import javax.inject.Inject

class NoteViewModel @Inject constructor(
    private val repository: NotesRepo
) : ViewModel() {
    fun insertData(it: NoteModel) {
        repository.insertNote(
            it
        )
    }

    val visitors by lazy {
        repository.getAllNotes()
    }
}