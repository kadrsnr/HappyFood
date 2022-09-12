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

class FoodListRecyclerAdapter @Inject constructor() : RecyclerView.Adapter<FoodListRecyclerAdapter.FoodListViewHolder>(){
    class FoodListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    private var diffUtil = object : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem==newItem
        }

    }
    private var recyclerViewDiff = AsyncListDiffer(this, diffUtil)

    var foodList : List<Food>
        get() = recyclerViewDiff.currentList
        set(value) = recyclerViewDiff.submitList(value)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_row,parent,false)
        return  FoodListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        val foodText = holder.itemView.findViewById<TextView>(R.id.recipeRowRecipeNameText)
        val foodss = foodList[position]
        holder.itemView.apply {
            foodText.text = "Name : ${foodss.name}"
        }

    }

    override fun getItemCount(): Int {
        return  foodList.size      }

}


