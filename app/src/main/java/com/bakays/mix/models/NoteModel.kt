package com.bakays.mix.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "notesData")
data class NoteModel (
    @PrimaryKey(autoGenerate = true)var id: Long? = null,
    val fio: String? = null,
    val age: Int? = null,
    val heigh: Int? = null,
    val photoPath: String? = null,
    val note: String? = null
) : Parcelable