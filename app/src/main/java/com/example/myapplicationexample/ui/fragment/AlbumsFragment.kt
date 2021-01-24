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
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.FragmentAlbumsBinding
import com.example.myapplicationexample.model.Details
import com.example.myapplicationexample.ui.adapter.AlbumsAdapter
import com.example.myapplicationexample.ui.viewmodel.GenresViewmodel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [AlbumsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlbumsFragment : Fragment() {

    lateinit var genresViewmodel: GenresViewmodel
    lateinit var binding: FragmentAlbumsBinding

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_albums, container, false)
        genresViewmodel = (activity as MainActivity).genresViewmodel

        genresViewmodel.getTagTopAlbums((activity as MainActivity).tag!!.name)
            .observe(viewLifecycleOwner, {
                binding.rvAlbums.apply {
                    layoutManager = GridLayoutManager(activity!!.applicationContext, 2)
                    setHasFixedSize(true)
                    if (it.albums != null && it.albums.album.size > 0)
                        adapter = AlbumsAdapter(it.albums.album?.map { album ->
                            Details(
                                name = album?.name ?: "",
                                image = album.image?.get(3).text,
                                track = album.artist.name
                            )
                        }, {
                            (activity as MainActivity).details = this
                            view!!.findNavController().navigate(R.id.fragmentSongs)
                        })
                }
            })
        return binding.root
    }

}