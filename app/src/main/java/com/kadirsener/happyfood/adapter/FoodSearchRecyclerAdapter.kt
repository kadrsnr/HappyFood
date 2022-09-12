package com.kadirsener.happyfood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kadirsener.happyfood.R
import com.kadirsener.happyfood.model.FoodResponse
import com.kadirsener.happyfood.model.FoodResult
import com.kadirsener.happyfood.roomdb.Food

class FoodSearchRecyclerAdapter(var foodlist: List<FoodResult>) :
    RecyclerView.Adapter<FoodSearchRecyclerAdapter.FoodSearchViewHolder>() {


    class FoodSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun bind(foodList: List<FoodResponse>, itemView: View) {


    }

    private var onItemClickListener: ((List<Any>) -> Unit)? = null


    lateinit var foodList: List<FoodResult>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_row, parent, false)
        return FoodSearchViewHolder(view)

    }

    private fun setOnItemClickListener(listener: (List<Any>) -> Unit) {
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: FoodSearchViewHolder, position: Int) {
        val textViewName = holder.itemView.findViewById<TextView>(R.id.searchRowFoodNameText)
        val textViewCalorie = holder.itemView.findViewById<TextView>(R.id.searchRowCalorieText)
        val searchFoods = foodList[position]
        holder.itemView.apply {
            textViewName.text = "${searchFoods.name}"
            textViewCalorie.text = "${searchFoods.calories}"


        }
    }

    override fun getItemCount(): Int {
        return foodList.size

        }


}






