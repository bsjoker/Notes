package com.bakays.mix.di.modules

import com.bakays.mix.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All your Activities participating in DI would be listed here.
 */
@Module() // Including Fragment Module Available For Activities
abstract class ActivityModule {

    /**
     * Marking Activities to be available to contributes for Android Injector
     */
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
