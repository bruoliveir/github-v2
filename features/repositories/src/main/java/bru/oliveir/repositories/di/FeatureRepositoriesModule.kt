package bru.oliveir.repositories.di

import bru.oliveir.repositories.RepositoriesViewModel
import bru.oliveir.repositories.domain.GetJavaRepositoriesUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureRepositoriesModule = module {
    factory { GetJavaRepositoriesUseCase(get()) }
    viewModel { RepositoriesViewModel(get()) }
}