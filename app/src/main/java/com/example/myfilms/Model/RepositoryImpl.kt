package com.example.myfilms.Model

class RepositoryImpl: Repository {
    override fun getFilmDetailsFromDB(): FilmDetails {
        return FilmDetails()
    }

    override fun getFilmListFromDB(): FilmList {
        return FilmList()
    }

    override fun getFilmDetailsFromLocal(): FilmDetails {
        return FilmDetails()
    }

    override fun getFilmListFromLocal(): FilmList {
        return FilmList()
    }
}