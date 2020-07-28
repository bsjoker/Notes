package com.bakays.mix.utils

import androidx.recyclerview.widget.DiffUtil
import com.bakays.mix.models.NoteModel

class NoteDiffCallback(private var oldList: List<NoteModel>?, private var newList: List<NoteModel>?) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList!!.size
    }

    override fun getNewListSize(): Int {
        return newList!!.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList!![oldItemPosition]
        val newItem = newList!![newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList!![oldItemPosition]
        val newItem = newList!![newItemPosition]
        return oldItem == newItem
    }
}