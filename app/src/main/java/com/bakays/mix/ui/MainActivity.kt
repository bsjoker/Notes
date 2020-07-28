package com.bakays.mix.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bakays.mix.utils.AddActivityContract
import com.bakays.mix.R
import com.bakays.mix.adapters.RVAdapter
import com.bakays.mix.di.BaseActivity
import com.bakays.mix.extentions.getViewModel
import com.bakays.mix.models.NoteModel
import com.bakays.mix.viewmodels.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var listOfNOtes: List<NoteModel> = ArrayList()
    lateinit var myAdapter: RVAdapter
    private val addNote = registerForActivityResult(AddActivityContract()) { result: NoteModel? ->
        result?.let {
            noteViewModel.insertData(it)
        }
    }

    private val noteViewModel by lazy {
        getViewModel<NoteViewModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.subtitle = "Your private list"
        actionBar.elevation = 4.0f

        noteViewModel.visitors.observe(this, Observer { notesList ->
            notesList?.let {
                myAdapter.update(it)
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        myAdapter = RVAdapter(listOfNOtes)
        recyclerView.adapter = myAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_note -> addNote.launch(this)
        }
        return super.onOptionsItemSelected(item)
    }
}