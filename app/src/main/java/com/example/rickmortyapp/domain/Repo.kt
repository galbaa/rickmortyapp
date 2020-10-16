package com.example.rickmortyapp.domain

import com.example.rickmortyapp.data.model.Character
import com.example.rickmortyapp.vo.Resource

interface Repo {
    suspend fun getCharacters(): Resource<List<Character>>
}