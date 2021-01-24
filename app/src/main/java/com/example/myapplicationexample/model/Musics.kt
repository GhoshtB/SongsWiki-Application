package com.example.myapplicationexample.model

data class MusicDetails(
    val tags: Tags
)

data class Tags(
    val attr: Attr,
    val tag: List<Tag>
)

/*
data class Attr(
    val page: String,
    val perPage: String,
    val total: String,
    val totalPages: String
)
*/

data class Tag(
    val name: String,
    val reach: String,
    val streamable: String,
    val taggings: String,
    val url: String,
    val wiki: Wiki
)

data class Attr(
    val page: String?="",
    val perPage: String?="",
    val tag: String?="",
    val total: String?="",
    val totalPages: String?=""
)


class Wiki(
)

data class Artist(
    val attr: AttrX,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)


data class Details(
    val name: String?,
    val image: String?,
    val track: String? ="",
    val playCount: String? ="",
    val followers: String? =""
)

data class Albums(
    val attr: Attr,
    val album: List<Album>
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

data class Image(
    val text: String,
    val size: String
)

