package `fun`.dooit.aac.view

import `fun`.dooit.aac.R
import `fun`.dooit.aac.data.Hero
import `fun`.dooit.aac.databinding.ActivityMainBinding
import `fun`.dooit.aac.repo.MarvelRepo
import `fun`.dooit.aac.vm.MainViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var repo: MarvelRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        repo = MarvelRepo()
        viewModel = MainViewModel(repo)

        btn_go.setOnClickListener {
            viewModel.getCharacter("spider")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    println("onNext = ${it}")
                    dataBinding.btnGo.text="GOOD"
                },{
                    println("onError = ${it}")
                },{
                    println("onComplete = ${it}")
                })

        }
    }
}
