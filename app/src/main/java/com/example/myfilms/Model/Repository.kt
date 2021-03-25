package com.example.myfilms.Model

interface Repository {
    fun getFilmDetailsFromDB(): FilmDetails
    fun getFilmListFromDB(): FilmList

    fun getFilmDetailsFromLocal(): FilmDetails
    fun getFilmListFromLocal(): FilmList
}