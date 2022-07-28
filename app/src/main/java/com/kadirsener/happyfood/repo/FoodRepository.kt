package com.kadirsener.happyfood.repo

import androidx.lifecycle.LiveData
import com.kadirsener.happyfood.api.RetrofitApi
import com.kadirsener.happyfood.model.FoodResponse
import com.kadirsener.happyfood.roomdb.Food
import com.kadirsener.happyfood.roomdb.FoodDao
import com.kadirsener.happyfood.util.Resource
import java.lang.Exception
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val foodDao : FoodDao,
    private val retrofitApi : RetrofitApi) : FoodRepositoryInterface {
    override suspend fun insertFood(food: Food) {
        foodDao.insertFood(food)    }

    override suspend fun deleteFood(food: Food) {
        foodDao.deleteFood(food)
    }

    override fun getFood(): LiveData<List<Food>> {
       return foodDao.observeFood() }

    override suspend fun searchFood(foodString: String): Resource<FoodResponse> {
        return try {
            val response = retrofitApi.foodSearch(foodString)
            if (response.isSuccessful) {
                response.body()?.let{
                     return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            }else {
                Resource.error("Error", null)
            }

        }catch (e : Exception) {
            Resource.error("No Data" , null)
        }
    }
}