package com.example.myapplicationexample.model.track

import com.example.myapplicationexample.model.track.toptrack.ToptracksX
import com.google.gson.annotations.SerializedName

data class TopTracks(
    val tracks: Tracks,
    val toptracks: ToptracksX
)


data class Tracks(
    @SerializedName("@attr") val attr: Attr,
    val track: List<Track>
)

data class Attr(
    val page: String,
    val perPage: String,
    val tag: String,
    val total: String,
    val totalPages: String
)

data class Track(
    @SerializedName("@attr")   val attr: AttrX,
    val artist: Artist,
    val duration: String,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: Streamable,
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

data class Streamable(
    @SerializedName("#text")  val text: String,
    val fulltrack: String
)