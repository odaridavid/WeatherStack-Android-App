package com.github.odaridavid.wingu.features.weather.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.github.odaridavid.wingu.R

internal class TabSwipePagerAdapter(
    context: Context,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager) {

    // region Members

    private val TAB_TITLES = arrayOf(
        context.getString(R.string.tab_title_today),
        context.getString(R.string.tab_title_tomorrow)
    )

    // endregion

    // region FragmentStatePagerAdapter

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> CurrentWeatherFragment()
        1 -> TomorrowsWeatherForecastFragment()
        else -> throw IllegalStateException()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return TAB_TITLES[position]
    }

    // endregion
}
