package co.buckleup.kotlin.kotlinsweet.di.main

import co.buckleup.kotlin.kotlinsweet.di.CustomScope
import co.buckleup.kotlin.kotlinsweet.main.MainPresenter
import co.buckleup.kotlin.kotlinsweet.main.MainPresenterImpl
import co.buckleup.kotlin.kotlinsweet.main.MainView
import dagger.Module
import dagger.Provides

@Module
class MainModule (@property:CustomScope @get:CustomScope @get:Provides var mainView: MainView){

    @Provides
    @CustomScope
    internal fun mainPresenter(mainView: MainView) : MainPresenter {
        return MainPresenterImpl(mainView)
    }

}