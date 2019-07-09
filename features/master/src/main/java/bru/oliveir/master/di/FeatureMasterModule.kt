package bru.oliveir.master.di

import bru.oliveir.master.MasterViewModel
import bru.oliveir.master.domain.GetAllItemsUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureMasterModule = module {
    factory { GetAllItemsUseCase(get()) }
    viewModel { MasterViewModel(get()) }
}