package com.example.rickmortyapp.domain

import com.example.rickmortyapp.data.DataSource
import com.example.rickmortyapp.data.model.Character
import com.example.rickmortyapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {
    override suspend fun getCharacters(): Resource<List<Character>> {
        return dataSource.getCharacters()
    }
}