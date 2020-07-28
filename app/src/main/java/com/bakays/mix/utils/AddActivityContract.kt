package com.bakays.mix.utils

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.bakays.mix.models.NoteModel
import com.bakays.mix.ui.AddActivity

class AddActivityContract : ActivityResultContract<Context, NoteModel?>() {
    override fun createIntent(context: Context, input: Context?): Intent {
        val intent = Intent(context, AddActivity::class.java)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): NoteModel? {
        return when (resultCode){
            RESULT_OK ->intent?.getParcelableExtra<NoteModel>("note")
            else -> null
        }
    }
}