package com.bakays.mix.extentions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bakays.mix.di.BaseActivity

/**
 * Synthetic sugaring to get instance of [ViewModel] for [AppCompatActivity].
 */
inline fun <reified T : ViewModel> BaseActivity.getViewModel(): T {
    return ViewModelProvider(this, viewModelFactory).get(T::class.java)
}

/**
 * Synthetic sugaring to get instance of [ViewModel] for [Fragment].
 */
inline fun <reified T : ViewModel> Fragment.getViewModel(): T {
    return ViewModelProvider(this).get(T::class.java)
}
