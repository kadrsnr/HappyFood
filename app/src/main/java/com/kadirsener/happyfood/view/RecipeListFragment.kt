package com.kadirsener.happyfood.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kadirsener.happyfood.R
import com.kadirsener.happyfood.adapter.FoodSearchRecyclerAdapter
import com.kadirsener.happyfood.databinding.FragmentRecipeListBinding
import javax.inject.Inject


class RecipeListFragment @Inject constructor(
   private var foodSearchAdapter: FoodSearchRecyclerAdapter,
) : Fragment(R.layout.fragment_recipe_list) {

    private var fragmentBinding: FragmentRecipeListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentRecipeListBinding.bind(view)
        fragmentBinding = binding


        binding.foodSearchRecyclerView.setOnClickListener {
            findNavController().navigate(RecipeDetailsFragmentDirections.actionRecipeDetailsFragmentToRecipeListFragment())
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)

    }


    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()

    }


}