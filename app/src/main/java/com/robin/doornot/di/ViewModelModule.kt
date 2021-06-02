package com.robin.doornot.di

import com.robin.doornot.ui.main.MainViewModel
import com.robin.doornot.ui.result.ResultViewModel
import com.robin.doornot.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
    viewModel { ResultViewModel() }
}