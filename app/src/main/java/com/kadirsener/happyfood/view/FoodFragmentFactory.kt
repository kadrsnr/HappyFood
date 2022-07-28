package com.kadirsener.happyfood.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.hilt.InstallIn
import javax.inject.Inject

class FoodFragmentFactory @Inject constructor() : FragmentFactory() {


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

            return when (className) {
                else ->       super.instantiate(classLoader, className)
            }
    }

}