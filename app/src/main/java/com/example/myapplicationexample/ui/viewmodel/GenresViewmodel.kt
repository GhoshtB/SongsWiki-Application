package com.example.myapplicationexample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myapplicationexample.model.MusicDetails
import com.example.myapplicationexample.model.alb.Albums
import com.example.myapplicationexample.model.alb.topalbm.TopAlbums
import com.example.myapplicationexample.model.artist.TopArtists
import com.example.myapplicationexample.model.track.TopTracks
import com.example.myapplicationexample.repo.Repository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GenresViewmodel @Inject constructor(val repository: Repository):ViewModel() {

    fun getMusucGenres(): LiveData<MusicDetails> {
        return repository.getGenresSong().asLiveData(context = Dispatchers.Main)
    }


    fun getTagTopAlbums( genre:String): LiveData<Albums> {
        return repository.getTagTopAlbums(genre).asLiveData(context = Dispatchers.Main)
    }


    fun getTagTopTracks(genre:String): LiveData<TopTracks> {
        return repository.getTagTopTracks(genre).asLiveData(context = Dispatchers.Main)
    }


    fun getTagTopartists(genre:String): LiveData<TopArtists> {
        return repository.getTagTopartists(genre).asLiveData(context = Dispatchers.Main)
    }


    fun getArtistTopTracks(artist:String): LiveData<TopTracks> {
        return repository.getArtistTopTracks(artist).asLiveData(context = Dispatchers.Main)
    }


    fun getArtistTopAlbums(artist:String): LiveData<TopAlbums> {
        return repository.getArtistTopAlbums(artist).asLiveData(context = Dispatchers.Main)
    }

}