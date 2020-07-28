package com.bakays.mix.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bakays.mix.models.NoteModel

@Dao
interface NotesDao {
    @Query("SELECT * FROM notesData")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(noteModel: NoteModel)
}