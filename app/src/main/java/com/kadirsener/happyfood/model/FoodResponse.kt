package com.kadirsener.happyfood.model

data class FoodResponse(

   //Serializeble kullanıyorsan retrofit ile her yerde uygulamalısın.
    val items : List<FoodResult>
)
