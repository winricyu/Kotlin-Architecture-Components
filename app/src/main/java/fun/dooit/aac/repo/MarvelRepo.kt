package `fun`.dooit.aac.repo

import `fun`.dooit.aac.data.Hero
import `fun`.dooit.paging.net.MarvelService
import io.reactivex.Observable
import retrofit2.Response

class MarvelRepo {

    fun getCharacter(name: String): Observable<Response<Hero>> {
        println("MarvelRepo.getCharacter, name = [${name}]")
        return MarvelService.create().getCharacter(name = name)
    }


}