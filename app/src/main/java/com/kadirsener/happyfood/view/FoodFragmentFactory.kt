package com.kadirsener.happyfood.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.kadirsener.happyfood.adapter.FoodListRecyclerAdapter
import com.kadirsener.happyfood.adapter.FoodSearchRecyclerAdapter
import javax.inject.Inject

class FoodFragmentFactory @Inject constructor(
    private val foodListRecyclerAdapter: FoodListRecyclerAdapter,
    private val foodSearchRecyclerAdapter: FoodSearchRecyclerAdapter
) : FragmentFactory() {


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

            return when (className) {
                RecipeListFragment::class.java.name -> RecipeListFragment(foodSearchRecyclerAdapter)
                FoodListFragment::class.java.name -> FoodListFragment(foodListRecyclerAdapter)
                else ->       super.instantiate(classLoader, className)
            }
    }

}