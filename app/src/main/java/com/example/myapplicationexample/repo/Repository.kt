package com.example.myapplicationexample.repo

import com.example.myapplicationexample.api.CommonApiServices
import com.example.myapplicationexample.api.MusicServices
import com.example.myapplicationexample.model.MusicDetails
import com.example.myapplicationexample.model.alb.Albums
import com.example.myapplicationexample.model.alb.topalbm.TopAlbums
import com.example.myapplicationexample.model.artist.TopArtists
import com.example.myapplicationexample.model.track.TopTracks
import com.example.myapplicationexample.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class Repository @Inject constructor(val commonApi:CommonApiServices):CoroutineScope {

    fun getGenresSong(): Flow<MusicDetails> {
        return flow<MusicDetails> {emit(getApiServices().getTags().execute().body()!!)  }.flowOn(Dispatchers.IO)
    }


     fun getTagTopAlbums( genre:String): Flow<Albums> {
        return flow<Albums> {emit(getApiServices().getTagTopAlbums(genre).execute().body()!!)  }.flowOn(Dispatchers.IO)
    }



     fun getTagTopTracks( genre:String): Flow<TopTracks> {
        return flow<TopTracks> {emit(getApiServices().getTagTopTracks(genre).execute().body()!!)  }.flowOn(Dispatchers.IO)
    }



     fun getTagTopartists( genre:String): Flow<TopArtists> {
        return flow<TopArtists> {emit(getApiServices().getTagTopartists(genre).execute().body()!!)  }.flowOn(Dispatchers.IO)
    }



     fun getArtistTopTracks( artist:String): Flow<TopTracks> {
        return flow<TopTracks> {emit(getApiServices().getArtistTopTracks(artist).execute().body()!!)  }.flowOn(Dispatchers.IO)
    }



     fun getArtistTopAlbums( artist:String): Flow<TopAlbums> {
        return flow<TopAlbums> {emit(getApiServices().getArtistTopAlbums(artist).execute().body()!!)  }.flowOn(Dispatchers.IO)
    }

   suspend fun getApiServices(): MusicServices {
      return withContext(coroutineContext) {
          commonApi.getApiServices(
              Constants.base_url,
              MusicServices::class.java
          )
      }
   }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}