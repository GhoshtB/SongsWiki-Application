package com.example.myapplicationexample.model.track.toptrack

import com.google.gson.annotations.SerializedName

data class TopTracks(
    val toptracks: ToptracksX
)

data class ToptracksX(
    @SerializedName("@attr") val attr: Attr,
    val track: List<Track>
)

data class Attr(
    val artist: String,
    val page: String,
    val perPage: String,
    val total: String,
    val totalPages: String
)

data class Track(
    @SerializedName("@attr") val attr: AttrX,
    val artist: Artist,
    val image: List<Image>,
    val listeners: String,
    val mbid: String,
    val name: String,
    val playcount: String,
    val streamable: String,
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
    @SerializedName("#text") val text: String,
    val size: String
)