package com.example.rickmortyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickmortyapp.domain.Repo
import com.example.rickmortyapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo: Repo): ViewModel() {

    val fetchCharactersList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try{
            emit(repo.getCharacters())
        }
        catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }
}