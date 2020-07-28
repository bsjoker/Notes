package com.bakays.mix.di.components

import com.bakays.mix.di.modules.AppModule
import com.bakays.mix.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Waheed on 04,November,2019
 */

/**
 * AndroidInjectionModule::class to support Dagger
 * AppModule::class is loading all modules for app
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}
