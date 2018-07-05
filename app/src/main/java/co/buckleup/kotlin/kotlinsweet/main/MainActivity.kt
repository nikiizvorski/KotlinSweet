package co.buckleup.kotlin.kotlinsweet.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.buckleup.kotlin.kotlinsweet.R
import co.buckleup.kotlin.kotlinsweet.di.main.DaggerMainComponent
import co.buckleup.kotlin.kotlinsweet.di.main.MainModule
import co.buckleup.kotlin.kotlinsweet.models.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView{
    @Inject lateinit var mainPresenter: MainPresenter

    val lazyValue: String by lazy {
        Toast.makeText(this, "computed!", Toast.LENGTH_LONG).show()
        "Hello"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        initDI()
    }

    private fun initUI() {
        Timber.d("INIT UI MAIN")
        thetext.setOnClickListener({ Toast.makeText(this, "This is my text" + lazyValue, Toast.LENGTH_LONG).show() })
    }

    private fun initDI() {
        Timber.d("INIT DI MAIN")
        DaggerMainComponent.builder().mainModule(MainModule(this)).build().inject(this)
        mainPresenter.showFunKotlin()
        mainPresenter.getUsers()
        mainPresenter.setUser()
    }

    override fun showKotlinFun(user: UserModel) {
        val blow : String = "${user.name} and ${user.phone}"
        Toast.makeText(this, "Show Fun: " + blow, Toast.LENGTH_LONG).show()
    }

    override fun showKotlin() {
        Toast.makeText(this, "Show Fun Msg", Toast.LENGTH_LONG).show()
    }

    override fun setUser(userModel: UserModel) {
        thetext.text = userModel.name + ":" + userModel.phone
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("DESTROY ACTIVITY")
        mainPresenter.onDestroy()
    }
}
