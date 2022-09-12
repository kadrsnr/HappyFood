package com.kadirsener.happyfood.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kadirsener.happyfood.model.FoodResponse
import com.kadirsener.happyfood.repo.FoodRepositoryInterface
import com.kadirsener.happyfood.roomdb.Food
import com.kadirsener.happyfood.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoodViewModel @Inject constructor(
    private val repository : FoodRepositoryInterface,

) : ViewModel() {

            val foodList = repository.getFood()

            private val searchFoods = MutableLiveData<Resource<FoodResponse>>()
            val searchFoodsList : LiveData<Resource<FoodResponse>>
                get() = searchFoods


            private val selectedFood = MutableLiveData<String>()
            val selectedFoodUrl : LiveData<String>
            get() = selectedFood


            private var insertFoodMsg = MutableLiveData<Resource<Food>>()
            val insertFoodMessage : LiveData<Resource<Food>>
            get() = insertFoodMsg

            fun resetInsterArtMsg () {
                insertFoodMsg = MutableLiveData<Resource<Food>>()
            }



            fun setSelectedFood (url : String) {
                    selectedFood.postValue(url)
            }

            fun deleteFood(food : Food) = viewModelScope.launch{
                repository.deleteFood(food)
            }

            fun insertFood(food : Food) = viewModelScope.launch {
                repository.insertFood(food)

            }

            fun makeRecipe (name : String) {
                if (name.isEmpty()) {
                    insertFoodMsg.postValue(Resource.error("Enter Name", null))
                    return
                } else {
                    val food = Food(name, calorie = 0, fat = 0, protein = 0, foodId = null)
                    insertFood(food)
                    insertFoodMsg.postValue(Resource.success(food))


                }

            }


            fun searchForFood(searchString : String) {
                if (searchString.isEmpty()){
                    return
                }
                    searchFoods.value = Resource.loading(null)
                    viewModelScope.launch {
                        val response = repository.searchFood(searchString)
                        searchFoods.value = response
                    }
            }










}