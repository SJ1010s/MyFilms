package com.example.myfilms.ViewModel

import com.example.myfilms.Model.FilmDetails

sealed class AppStateFilmDetails {
    data class Success(val filmDetails: FilmDetails): AppStateFilmDetails()
    data class Error(val error: Throwable): AppStateFilmDetails()
    object Loading: AppStateFilmDetails()
}