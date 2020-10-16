package com.example.rickmortyapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("species")
    val species: String
): Parcelable

data class CharactersResponse(
    @SerializedName("results")
    val results: List<Character>
)