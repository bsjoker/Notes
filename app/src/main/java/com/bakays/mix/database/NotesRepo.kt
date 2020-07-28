package com.bakays.mix.database

import androidx.lifecycle.LiveData
import com.bakays.mix.models.NoteModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesRepo @Inject constructor(
    private val notesDao: NotesDao
) {
    fun getAllNotes(): LiveData<List<NoteModel>>{
        return notesDao.getAllNotes()
    }

    fun insertNote(noteModel: NoteModel){
        Thread {
            notesDao.addNote(noteModel)
        }.start()

    }
}