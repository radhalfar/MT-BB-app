package cz.fai.utb.mt_bb_app.model

data class BreakingBadQuote (
    val quote: String,
    val author: String,
)

data class BreakingBadQuoteList(
    val quotes: List<BreakingBadQuote>
)