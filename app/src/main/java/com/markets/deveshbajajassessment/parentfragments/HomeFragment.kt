package com.markets.deveshbajajassessment.parentfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.markets.deveshbajajassessment.R
import com.markets.deveshbajajassessment.ViewPagerAdapter
import com.markets.deveshbajajassessment.childfragments.*


class HomeFragment : Fragment() {

    private lateinit var mainTl: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val childVp = view.findViewById<ViewPager>(R.id.childVp)
        mainTl = view.findViewById(R.id.mainTl)

        setupViewPager(childVp)

        mainTl.setupWithViewPager(childVp)
        setupTabIcons()

        return view

    }

    private fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        // HomeFragment is the name of Fragment and the Home
        // is a title of tab
        adapter.addFragment(ForYouFragment(), getString(R.string.for_you))
        adapter.addFragment(TopChartsFragment(), getString(R.string.top_charts))
        adapter.addFragment(CategoriesFragment(), getString(R.string.categories))
        adapter.addFragment(EditorsChoiceFragment(), getString(R.string.editors_choice))
        adapter.addFragment(EarlyAccessFragment(), getString(R.string.early_access))
        adapter.addFragment(FamilyFragment(), getString(R.string.family))

        // setting adapter to view pager.
        viewpager.adapter = adapter
    }

    private fun setupTabIcons() {
        setUpCustomTabLayoutForSubLayout(0, R.string.for_you, R.drawable.ic_for_you_gray)
        setUpCustomTabLayoutForSubLayout(1, R.string.top_charts, R.drawable.ic_top_charts_gray)
        setUpCustomTabLayoutForSubLayout(2, R.string.categories, R.drawable.ic_categories_gray)
        setUpCustomTabLayoutForSubLayout(
            3, R.string.editors_choice, R.drawable.ic_editors_choice_gray
        )
        setUpCustomTabLayoutForSubLayout(4, R.string.early_access, R.drawable.ic_early_access_gray)
        setUpCustomTabLayoutForSubLayout(5, R.string.family, R.drawable.ic_family_gray)

/*        setUpCustomTabLayoutForSubLayout(0, R.drawable.ic_for_you_gray)
        setUpCustomTabLayoutForSubLayout(1, R.drawable.ic_top_charts_gray)
        setUpCustomTabLayoutForSubLayout(2, R.drawable.ic_categories_gray)
        setUpCustomTabLayoutForSubLayout(3, R.drawable.ic_editors_choice_gray)
        setUpCustomTabLayoutForSubLayout(4, R.drawable.ic_early_access_gray)
        setUpCustomTabLayoutForSubLayout(5, R.drawable.ic_family_gray)*/
    }

    private fun setUpCustomTabLayoutForSubLayout(index: Int, name: Int, drawable: Int) {
        val tabOne = LayoutInflater.from(context).inflate(R.layout.custom_sub_tab, null) as TextView
        tabOne.setText(name)
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, drawable, 0, 0)
        mainTl.getTabAt(index)?.customView = tabOne
    }

    private fun setUpCustomTabLayoutForSubLayout(index: Int, drawable: Int) {
        mainTl.getTabAt(index)?.setIcon(drawable)
    }

}