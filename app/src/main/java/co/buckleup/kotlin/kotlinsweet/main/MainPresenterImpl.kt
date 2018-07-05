package co.buckleup.kotlin.kotlinsweet.main

import co.buckleup.kotlin.kotlinsweet.models.UserModel
import javax.inject.Inject



class MainPresenterImpl @Inject constructor(var mainView: MainView) : MainPresenter {

    override fun setUser() {
        mainView.setUser(UserModel("Niki","+447"))
    }

    override fun getUsers() {
        mainView.showKotlinFun(UserModel("Niki","+447"))
    }

    override fun showFunKotlin() {
        mainView.showKotlin()
    }

    override fun onDestroy(){
        //mainView = null
    }
}