package com.markets.deveshbajajassessment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.markets.deveshbajajassessment.*
import com.markets.deveshbajajassessment.parentfragments.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar?.isShowing == true)
            supportActionBar?.hide()

        val parentVp = findViewById<ViewPager>(R.id.parentVp)
        val mainTl = findViewById<TabLayout>(R.id.mainTl)

        setupViewPager(parentVp)

        mainTl.setupWithViewPager(parentVp)


    }

    private fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // HomeFragment is the name of Fragment and the Home
        // is a title of tab
        adapter.addFragment(HomeFragment(), "HOME")
        adapter.addFragment(GamesFragment(), "GAMES")
        adapter.addFragment(MoviesFragment(), "MOVIES")
        adapter.addFragment(MusicFragment(), "MUSIC")
        adapter.addFragment(BooksFragment(), "BOOKS")

        // setting adapter to view pager.
        viewpager.adapter = adapter
    }


}