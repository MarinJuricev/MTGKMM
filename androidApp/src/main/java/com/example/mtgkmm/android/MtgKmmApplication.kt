package com.example.mtgkmm.android

import android.app.Application
import com.example.mtgkmm.android.core.di.coreModule
import com.example.mtgkmm.android.feature.card.detail.di.detailPresentationModule
import com.example.mtgkmm.android.feature.card.search.di.searchPresentationModule
import com.example.mtgkmm.android.feature.settings.di.settingsModule
import com.example.mtgkmm.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MtgKmmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MtgKmmApplication)
            modules(coreModule, searchPresentationModule, detailPresentationModule, settingsModule)
        }
    }
}
