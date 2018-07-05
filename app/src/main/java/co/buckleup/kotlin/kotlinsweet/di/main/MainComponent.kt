package co.buckleup.kotlin.kotlinsweet.di.main

import co.buckleup.kotlin.kotlinsweet.main.MainActivity
import co.buckleup.kotlin.kotlinsweet.di.CustomScope
import dagger.Component

@CustomScope
@Component(modules = arrayOf(MainModule :: class))
interface MainComponent {
    fun inject(mainActivity: MainActivity?)
}