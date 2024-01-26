package cz.fai.utb.mt_bb_app

import android.app.Application
import cz.fai.utb.mt_bb_app.api.BreakingBadApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    val apiService: BreakingBadApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.breakingbadquotes.xyz/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(BreakingBadApiService::class.java)
    }

    val repository: Repository by lazy {
        Repository(apiService)
    }

    override fun onCreate() {
        super.onCreate()
    }
}