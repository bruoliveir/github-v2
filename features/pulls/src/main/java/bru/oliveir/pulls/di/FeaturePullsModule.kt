package bru.oliveir.pulls.di

import bru.oliveir.pulls.PullsViewModel
import bru.oliveir.pulls.domain.GetPullsByRepositoryUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featurePullsModule = module {
    factory { GetPullsByRepositoryUseCase(get()) }
    viewModel { PullsViewModel(get()) }
}