package bru.oliveir.playground

import android.app.Application
import bru.oliveir.local.di.localModule
import bru.oliveir.pulls.di.featurePullsModule
import bru.oliveir.remote.di.remoteModule
import bru.oliveir.repositories.di.featureRepositoriesModule
import bru.oliveir.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() {
        startKoin {
            androidContext(this@App)
            modules(listOf(localModule, remoteModule, repositoryModule, featureRepositoriesModule, featurePullsModule))
        }
    }
}