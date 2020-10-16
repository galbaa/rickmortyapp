package com.example.rickmortyapp.data

import com.example.rickmortyapp.data.model.Character
import com.example.rickmortyapp.domain.RickMortyClient
import com.example.rickmortyapp.vo.Resource

class DataSource {

    suspend fun getCharacters(): Resource<List<Character>>{
        return Resource.Success(RickMortyClient.webservice.getCharacters().results)
    }
}