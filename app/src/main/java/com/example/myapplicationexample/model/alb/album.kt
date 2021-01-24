package com.example.myapplicationexample.model.alb

import com.google.gson.annotations.SerializedName

data class Albums(
    val albums: AlbumsX
)

data class AlbumsX(
    val attr: Attr,
    val album: List<Album>
)

data class Attr(
    val page: String,
    val perPage: String,
    val tag: String,
    val total: String,
    val totalPages: String
)

data class Album(
    val attr: AttrX,
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val url: String
)

data class AttrX(
    val rank: String
)

data class Artist(
    val mbid: String,
    val name: String,
    val url: String
)

data class Image(
    @SerializedName("#text")  val text: String,
    val size: String
)