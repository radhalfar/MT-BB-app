package cz.fai.utb.mt_bb_app

import cz.fai.utb.mt_bb_app.api.BreakingBadApiService
import cz.fai.utb.mt_bb_app.model.BreakingBadQuote

class Repository (private val apiService: BreakingBadApiService) {
    suspend fun getBBQuote() : BreakingBadQuote? {
        val response = apiService.getBBQuote()

        if(response.isSuccessful) {
            return response.body()
        }
        else {
            return null
        }
    }
}