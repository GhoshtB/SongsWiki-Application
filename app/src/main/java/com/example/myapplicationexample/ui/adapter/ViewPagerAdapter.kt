package com.example.myapplicationexample.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myapplicationexample.ui.fragment.AlbumsFragment
import com.example.myapplicationexample.ui.fragment.ArtistsFragment
import com.example.myapplicationexample.ui.fragment.TracksFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, count: Int) :
    FragmentStatePagerAdapter(fragmentManager, count) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            AlbumsFragment()
        } else if (position == 1) {
            ArtistsFragment()
        } else {
            TracksFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            "Albums"
        } else if (position == 1) {
            "Artists"
        } else {
            "Tracks"
        }
    }
}