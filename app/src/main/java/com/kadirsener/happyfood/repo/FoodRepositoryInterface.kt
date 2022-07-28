package com.kadirsener.happyfood.repo

import androidx.lifecycle.LiveData
import com.kadirsener.happyfood.model.FoodResponse
import com.kadirsener.happyfood.roomdb.Food
import com.kadirsener.happyfood.util.Resource

interface FoodRepositoryInterface {


    suspend fun insertFood(food : Food)

    suspend fun deleteFood(food : Food)

    fun getFood() : LiveData<List<Food>>

    suspend fun searchFood(foodString : String) : Resource<FoodResponse>
}