package com.example.mtgkmm.android

import android.app.Application
import com.example.mtgkmm.android.core.di.coreModule
import com.example.mtgkmm.android.search.di.searchPresentationModule
import com.example.mtgkmm.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MtgKmmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MtgKmmApplication)
            modules(
                searchPresentationModule,
                coreModule,
            )
        }
    }
}