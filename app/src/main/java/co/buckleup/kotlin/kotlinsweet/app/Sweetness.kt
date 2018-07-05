package co.buckleup.kotlin.kotlinsweet.app

import android.app.Application
import timber.log.Timber

class Sweetness : Application() {

    override fun onCreate() {
        super.onCreate()
        setTimber()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }

    override fun onTerminate() {
        super.onTerminate()
        Timber.d("Terminate App")
    }
}