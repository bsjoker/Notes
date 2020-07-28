package com.bakays.mix.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bakays.mix.di.base.ViewModelFactory
import com.bakays.mix.di.base.ViewModelKey
import com.bakays.mix.viewmodels.NoteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Waheed on 04,November,2019
 */

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindNoteViewModel(viewModel: NoteViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}