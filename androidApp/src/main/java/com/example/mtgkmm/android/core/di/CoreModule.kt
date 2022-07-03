package com.example.mtgkmm.android.core.di

import com.example.mtgkmm.android.core.components.topbar.TopBarViewModel
import com.example.mtgkmm.android.core.navigation.Navigator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModule = module {
    single { Navigator() }

    viewModel { TopBarViewModel() }
}
