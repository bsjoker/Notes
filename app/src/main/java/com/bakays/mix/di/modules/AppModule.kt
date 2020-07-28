package com.bakays.mix.di.modules

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.bakays.mix.App
import com.bakays.mix.database.AppDatabase
import com.bakays.mix.database.NotesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [PrefrencesModule::class, ActivityModule::class, ViewModelModule::class])
class AppModule {

//    /**
//     * Static variables to hold base url's etc.
//     */
//    companion object {
//        private const val BASE_URL = BuildConfig.BASE_URL
//    }
//
//
//    /**
//     * Provides ApiServices client for Retrofit
//     */
//    @Singleton
//    @Provides
//    fun provideNewsService(): ApiServices {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactoryForRetrofit())
//            .build()
//            .create(ApiServices::class.java)
//    }
//
//
    /**
     * Provides app AppDatabase
     */
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "notesDB").build()
    }


    /**
     * Provides NewsArticlesDao an object to access NewsArticles table from Database
     */
    @Singleton
    @Provides
    fun provideNotesDao(db: AppDatabase): NotesDao {
        return db.notesDao()
    }
//
//    /**
//     * Provides CountriesDao an object to access Countries table from Database
//     */
//    @Singleton
//    @Provides
//    fun provideCountriesDao(db: AppDatabase): CountriesDao {
//        return db.countriesDao()
//    }


    /**
     * Application application level context.
     */
    @Singleton
    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }


    /**
     * Application resource provider, so that we can get the Drawable, Color, String etc at runtime
     */
    @Provides
    @Singleton
    fun providesResources(application: App): Resources = application.resources
}
