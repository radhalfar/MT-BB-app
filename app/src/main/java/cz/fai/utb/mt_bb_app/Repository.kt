package cz.fai.utb.mt_bb_app

import android.util.Log
import cz.fai.utb.mt_bb_app.api.BreakingBadApiService
import cz.fai.utb.mt_bb_app.model.BreakingBadQuote

class Repository (private val apiService: BreakingBadApiService) {
    suspend fun getBBQuote() : BreakingBadQuote? {
        Log.d("FUCK IT", "BBQ")
        val response = apiService.getBBQuote()

        Log.d("FUCK IT", response.body().toString())

        if(response.isSuccessful) {
            return response.body()?.firstOrNull()
        }
        else {
            return null
        }
    }
}