package cz.fai.utb.mt_bb_app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.fai.utb.mt_bb_app.Repository
import cz.fai.utb.mt_bb_app.model.BreakingBadQuote

class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _breakingBadQuote = MutableLiveData<BreakingBadQuote>()
    val breakingBadQuote : LiveData<BreakingBadQuote> = _breakingBadQuote

    private val _text = MutableLiveData<String>().apply {
        value = breakingBadQuote.value?.quote;
    }
    val text: LiveData<String> = _text
}