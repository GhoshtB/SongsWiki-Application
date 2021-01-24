package com.example.myapplicationexample.model.artist

import com.google.gson.annotations.SerializedName

data class TopArtists(
    val topartists: TopartistsX
)

data class TopartistsX(
    @SerializedName("@attr") val attr: Attr,
    val artist: List<Artist>
)

data class Attr(
    val page: String,
    val perPage: String,
    val tag: String,
    val total: String,
    val totalPages: String
)

data class Artist(
    @SerializedName("@attr")  val attr: AttrX,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)

data class AttrX(
    val rank: String
)

data class Image(
    @SerializedName("#text") val text: String,
    val size: String
)