package co.buckleup.kotlin.kotlinsweet.main

import co.buckleup.kotlin.kotlinsweet.models.UserModel

public interface MainView {
    fun showKotlinFun(user: UserModel)
    fun showKotlin()
    fun setUser(userModel: UserModel)
}