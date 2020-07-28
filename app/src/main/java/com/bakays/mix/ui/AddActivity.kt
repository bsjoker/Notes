package com.bakays.mix.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.invoke
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bakays.mix.R
import com.bakays.mix.models.NoteModel
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "AddActivity"
        private const val GALLERY_REQUEST = 1
    }

    var path: Uri? = null

//    private val pickImages = registerForActivityResult(ActivityResultContracts.GetContent()) {uri ->
//        uri?.let {uri ->
//            path = uri
//            ivAddPhoto.setImageURI(path)
//        }
//    }

    private val askLocationPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        if(result){
            Log.e("TAG", "Location permnission granted")
        }else{
            Log.e("TAG", "Location permnission denied")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        askLocationPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        ivAddPhoto.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.setType("image/*")
            photoPickerIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivityForResult(photoPickerIntent,
                GALLERY_REQUEST
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val new_note = NoteModel(
            fio = et_fio.text.toString(),
            age = if (!et_age.text.isNullOrEmpty()) et_age.text.toString().toInt() else 0,
            heigh = if (!et_height.text.isNullOrEmpty()) et_height.text.toString().toInt() else 0,
            note = et_note.text.toString(),
            photoPath = path.toString()
        )
        when (item.itemId) {
            R.id.action_ok -> {
                setResult(Activity.RESULT_OK, Intent().apply { putExtra("note", new_note) })
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            GALLERY_REQUEST -> if (resultCode == Activity.RESULT_OK) {
                val selectedImage: Uri? = data?.data

                selectedImage?.let {
                    path = it
                    ivAddPhoto.setImageURI(path)
                }
            }
        }
    }
}