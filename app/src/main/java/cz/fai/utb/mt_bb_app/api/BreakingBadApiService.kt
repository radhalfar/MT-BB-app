package cz.fai.utb.mt_bb_app.api

import cz.fai.utb.mt_bb_app.model.BreakingBadQuote
import cz.fai.utb.mt_bb_app.model.BreakingBadQuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingBadApiService {
    companion object {
        const val BREAKING_BAD_QUOTES_ENDPOINT = "v1/quotes/";
    }

    @GET(BREAKING_BAD_QUOTES_ENDPOINT)
    suspend fun getBBQuote (

    ) : Response<List<BreakingBadQuote>>

}