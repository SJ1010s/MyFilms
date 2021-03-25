package com.example.myfilms.ViewModel

import com.example.myfilms.Model.FilmList

sealed class AppStateFilmList {
    data class Success(val filmList: FilmList) : AppStateFilmList()
    data class Error(val error: Throwable) : AppStateFilmList()
    object Loading : AppStateFilmList()
}