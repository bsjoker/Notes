package com.bakays.mix.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bakays.mix.database.NotesRepo

class NoteViewModelFactory (
    private val repository: NotesRepo
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}