package com.kadirsener.happyfood.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Food::class], version = 1)
abstract class FoodDataBase : RoomDatabase(){

            abstract fun foodDao () : FoodDao

}