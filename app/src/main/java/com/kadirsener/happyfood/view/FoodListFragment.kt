package com.kadirsener.happyfood.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.kadirsener.happyfood.R
import com.kadirsener.happyfood.databinding.FragmentFoodListBinding

class FoodListFragment : Fragment(R.layout.fragment_food_list) {

        private var fragmentBinding : FragmentFoodListBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val binding = FragmentFoodListBinding.bind(view)
            fragmentBinding = binding

            binding.fab.setOnClickListener {
                findNavController().navigate(FoodListFragmentDirections.actionFoodListFragmentToRecipeListFragment())
            }

    }


    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()

    }
}