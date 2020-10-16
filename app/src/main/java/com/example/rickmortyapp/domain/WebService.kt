package com.example.rickmortyapp.domain

import com.example.rickmortyapp.data.model.CharactersResponse
import com.example.rickmortyapp.vo.Resource
import retrofit2.http.GET

interface WebService {

    @GET("/character")
    suspend fun getCharacters() : CharactersResponse
}