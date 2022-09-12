package com.kadirsener.happyfood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kadirsener.happyfood.R
import com.kadirsener.happyfood.roomdb.Food
import javax.inject.Inject

class FoodSearchRecyclerAdapter @Inject constructor() :
    RecyclerView.Adapter<FoodSearchRecyclerAdapter.FoodSearchViewHolder>() {


    class FoodSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var onItemClickListener : ((String) -> Unit)? = null

    private var diffUtill = object : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }
    }
    private var recyclerViewDiff = AsyncListDiffer(this, diffUtill)
    var searchFoods: List<Food>
        get() = recyclerViewDiff.currentList
        set(value) = recyclerViewDiff.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_row, parent, false)
        return FoodSearchViewHolder(view)

    }
    fun setOnItemClickListener(listener : (String) -> Unit) {
        onItemClickListener = listener
    }
    override fun onBindViewHolder(holder: FoodSearchViewHolder, position: Int) {
        val textViewName = holder.itemView.findViewById<TextView>(R.id.searchRowFoodNameText)
        val textViewCalorie = holder.itemView.findViewById<TextView>(R.id.searchRowCalorieText)
        val searchFoods = searchFoods[position]
        holder.itemView.apply {
            textViewName.text = "${searchFoods.name}"
            textViewCalorie.text="${searchFoods.calorie}"
            setOnItemClickListener {
                onItemClickListener?.let{

                }
            }
        }


    }

    override fun getItemCount(): Int {
        return searchFoods.size
    }
}


