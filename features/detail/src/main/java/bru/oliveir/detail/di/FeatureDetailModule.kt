package bru.oliveir.detail.di

import bru.oliveir.detail.DetailViewModel
import bru.oliveir.detail.domain.GetAllItemsUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureDetailModule = module {
    factory { GetAllItemsUseCase(get()) }
    viewModel { DetailViewModel(get()) }
}