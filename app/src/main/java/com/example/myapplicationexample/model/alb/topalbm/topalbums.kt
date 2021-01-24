package com.example.myapplicationexample.model.alb.topalbm

import com.google.gson.annotations.SerializedName

data class TopAlbums(
    val topalbums: TopalbumsX
)

data class TopalbumsX(
    @SerializedName("@attr") val attr: Attr,
    val album: List<Album>
)

data class Attr(
    val artist: String,
    val page: String,
    val perPage: String,
    val total: String,
    val totalPages: String
)

data class Album(
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val playcount: Int,
    val url: String
)

data class Artist(
    val mbid: String,
    val name: String,
    val url: String
)

data class Image(
    @SerializedName("#text") val text: String,
    val size: String
)