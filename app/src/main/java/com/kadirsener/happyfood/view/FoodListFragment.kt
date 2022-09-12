package com.kadirsener.happyfood.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kadirsener.happyfood.R
import com.kadirsener.happyfood.adapter.FoodListRecyclerAdapter
import com.kadirsener.happyfood.databinding.FragmentFoodListBinding
import com.kadirsener.happyfood.viewmodel.FoodViewModel
import javax.inject.Inject

class FoodListFragment @Inject constructor(
    val foodReyclerAdapter: FoodListRecyclerAdapter
) : Fragment(R.layout.fragment_food_list) {

    lateinit var viewModel: FoodViewModel

    private var fragmentBinding: FragmentFoodListBinding? = null

    private val swipedCallBack =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val layoutPosition = viewHolder.layoutPosition
                val selectedFood = foodReyclerAdapter.foodList[layoutPosition]
                viewModel.deleteFood(selectedFood)

            }

        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFoodListBinding.bind(view)
        fragmentBinding = binding
        viewModel = ViewModelProvider(requireActivity()).get(FoodViewModel::class.java)
        subscribeToObververs()
        binding.foodlistReecyclerView.adapter = foodReyclerAdapter
        binding.foodlistReecyclerView.layoutManager = LinearLayoutManager(requireContext())
        ItemTouchHelper(swipedCallBack).attachToRecyclerView(binding.foodlistReecyclerView)
        binding.fab.setOnClickListener {
            findNavController().navigate(FoodListFragmentDirections.actionFoodListFragmentToRecipeListFragment())
        }

    }

    private fun subscribeToObververs() {
        viewModel.foodList.observe(viewLifecycleOwner, Observer {
            foodReyclerAdapter.foodList = it
        })
    }


    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()

    }
}