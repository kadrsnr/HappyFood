package com.kadirsener.happyfood.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.kadirsener.happyfood.api.RetrofitApi
import com.kadirsener.happyfood.repo.FoodRepository
import com.kadirsener.happyfood.repo.FoodRepositoryInterface
import com.kadirsener.happyfood.roomdb.FoodDao
import com.kadirsener.happyfood.roomdb.FoodDataBase
import com.kadirsener.happyfood.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun insterRoomDB(
         @ApplicationContext context: Context) = Room.databaseBuilder(
         context, FoodDataBase::class.java, "HappyFoodDataBase")
         .build()

        @Singleton
        @Provides
        fun injectDao (dataBase: FoodDataBase) = dataBase.foodDao()


        @Singleton
        @Provides
        fun injectRetfofitAPI() : RetrofitApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(RetrofitApi::class.java)
        }

        @Singleton
        @Provides
        fun injectNormalRepo (dao : FoodDao, api : RetrofitApi) = FoodRepository(dao,api) as FoodRepositoryInterface





}