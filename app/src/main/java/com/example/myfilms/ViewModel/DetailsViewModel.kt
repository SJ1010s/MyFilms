package com.example.myfilms.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfilms.Model.Repository
import com.example.myfilms.Model.RepositoryImpl
import java.lang.Thread.sleep

class DetailsViewModel(
        private val liveDataToObserver: MutableLiveData<AppStateFilmDetails> = MutableLiveData(),
        private val repositoryImpl: Repository = RepositoryImpl()) :
        ViewModel() {

    fun getLiveData() = liveDataToObserver

    private fun getDataFromLocalSource() {
        liveDataToObserver.value = AppStateFilmDetails.Loading
        Thread {
            sleep(1000
            )
            liveDataToObserver.postValue(AppStateFilmDetails.Success(repositoryImpl.getFilmDetailsFromLocal()))
        }.start()
    }

}

