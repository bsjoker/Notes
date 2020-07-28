package com.bakays.mix.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bakays.mix.utils.NoteDiffCallback
import com.bakays.mix.models.NoteModel
import com.bakays.mix.R
import kotlinx.android.synthetic.main.item_rv.view.*

class RVAdapter(var notes: List<NoteModel>) : RecyclerView.Adapter<RVAdapter.RVViewHolder>() {
    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.textFio.text = if (!notes[position].fio.isNullOrBlank()) notes[position].fio else "-"
        holder.textAge.text = if (!notes[position].age.toString().isBlank()) notes[position].age.toString() else "-"
        holder.textHeight.text = if (!notes[position].heigh.toString().isBlank()) notes[position].heigh.toString() else "-"
        holder.textNote.text = if (!notes[position].note.toString().isBlank()) notes[position].note else "-"
        holder.ivPhoto.setImageURI(notes[position].photoPath?.toUri())
    }

    override fun getItemCount() = notes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return RVViewHolder(view)
    }

    fun update(notesList: List<NoteModel>) {
        val noteDiffUtilCallback =
            NoteDiffCallback(notes, notesList)
        val noteDiffResult = DiffUtil.calculateDiff(noteDiffUtilCallback)
        notes = notesList
        noteDiffResult.dispatchUpdatesTo(this)
    }

    inner class RVViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textFio: TextView = itemView.tvName
        val textAge: TextView = itemView.tvAge
        val textHeight: TextView = itemView.tvHeight
        val textNote: TextView = itemView.tvNote
        val ivPhoto: ImageView = itemView.ivPhoto
    }
}
