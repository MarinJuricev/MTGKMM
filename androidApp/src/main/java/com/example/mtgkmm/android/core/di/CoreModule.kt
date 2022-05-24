package com.example.mtgkmm.android.core.di

import com.example.mtgkmm.android.core.navigation.Navigator
import com.example.mtgkmm.android.core.topbar.TopBarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModule = module {
    single { Navigator() }

    viewModel { TopBarViewModel() }
}