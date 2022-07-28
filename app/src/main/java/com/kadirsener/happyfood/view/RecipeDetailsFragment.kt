package com.kadirsener.happyfood.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.kadirsener.happyfood.R
import com.kadirsener.happyfood.databinding.FragmentRecipeDetailsBinding


class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {

    private var fragmentBinding : FragmentRecipeDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val binding = FragmentRecipeDetailsBinding.bind(view)
            fragmentBinding = binding

        binding.recipeDetailsFab.setOnClickListener {
            findNavController().navigate(RecipeDetailsFragmentDirections.actionRecipeDetailsFragmentToRecipeListFragment())
        }

    }


    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()

    }
}