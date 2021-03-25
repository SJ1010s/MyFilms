package com.example.myfilms.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfilms.Model.Repository
import com.example.myfilms.Model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
        private val liveDataToObserver: MutableLiveData<AppStateFilmList> = MutableLiveData(),
        private val repositoryImpl: Repository = RepositoryImpl()) :
        ViewModel() {

    fun getLiveData() = liveDataToObserver
    fun getFilmFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserver.value = AppStateFilmList.Loading
        Thread {
            sleep(1000
            )
            liveDataToObserver.postValue(AppStateFilmList.Success(repositoryImpl.getFilmListFromLocal()))
        }.start()
    }

}

