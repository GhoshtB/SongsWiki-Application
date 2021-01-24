package com.example.myapplicationexample.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.FragmentSongsBinding
import com.example.myapplicationexample.model.Details
import com.example.myapplicationexample.ui.adapter.AlbumsAdapter
import com.example.myapplicationexample.ui.viewmodel.GenresViewmodel
import com.squareup.picasso.Picasso


/**
 * A simple [Fragment] subclass.
 * Use the [SongsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SongsFragment : Fragment() {

    lateinit var binding: FragmentSongsBinding
    lateinit var genresViewmodel: GenresViewmodel

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_songs, container, false)
        genresViewmodel = (activity as MainActivity).genresViewmodel
        binding.tvName.text = (activity as MainActivity).details!!.name ?: ""
        Picasso.get().load((activity as MainActivity).details!!.image)
            .placeholder(R.drawable.ic_launcher_background).into(binding.ivSrcImage)

        binding.ivBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        genresViewmodel.getArtistTopAlbums((activity as MainActivity).details!!.name!!)
            .observe(viewLifecycleOwner, {
                binding.rvAlbums.apply {
                    layoutManager = LinearLayoutManager(
                        activity!!.applicationContext,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    setHasFixedSize(true)
                    if (it.topalbums != null && it.topalbums.album.size > 0)
                        adapter = AlbumsAdapter(it.topalbums.album?.map { artist ->
                            Details(
                                name = artist.name ?: "", image = artist.image?.get(2).text ?: ""
                            )
                        }, {})
                }
            })


        genresViewmodel.getArtistTopTracks((activity as MainActivity).details!!.name!!)
            .observe(viewLifecycleOwner, {
                binding.rvTopTracks.apply {
                    layoutManager = LinearLayoutManager(
                        activity!!.applicationContext,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    setHasFixedSize(true)
                    if (it.toptracks != null && it.toptracks.track.size > 0)
                        adapter = AlbumsAdapter(it.toptracks.track?.map { artist ->
                            Details(
                                name = artist.name ?: "", image = artist.image?.get(2).text
                            )
                        }, {

                        })
                }
            })


        return binding.root
    }

}