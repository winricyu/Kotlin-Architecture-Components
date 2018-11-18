package `fun`.dooit.aac.vm

import `fun`.dooit.aac.data.Hero
import `fun`.dooit.aac.repo.MarvelRepo
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import retrofit2.Response

class MainViewModel(private val repo: MarvelRepo) : ViewModel() {

    fun getCharacter(name: String): Observable<Response<Hero>> {
        println("MainViewModel.getCharacter, name = [${name}]")
        return repo.getCharacter(name)
    }

}