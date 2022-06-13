package com.example.rawgmy.main.di

import com.example.rawgmy.main.interactor.MainInteractor
import com.example.rawgmy.main.repository.MainRemoteRepository
import com.example.rawgmy.main.ui.MainContract
import com.example.rawgmy.main.ui.MainPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


object MainModule {
    fun create() = module {
        singleOf(::MainPresenter) bind MainContract.Presenter::class
        factoryOf(::MainInteractor)
        singleOf(::MainRemoteRepository)
    }
}