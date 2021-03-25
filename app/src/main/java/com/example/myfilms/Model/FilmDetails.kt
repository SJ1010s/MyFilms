package com.example.myfilms.Model

data class FilmDetails (
    val filmId: Int = 1,
    val filmTitle: String = "В зоне особого внимания",
    val filmVoteAverage: String = "8,5",
    val filmOverView: String? = "Описание")