package cz.fai.utb.mt_bb_app.ui.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.fai.utb.mt_bb_app.Repository
import cz.fai.utb.mt_bb_app.model.BreakingBadQuote
import cz.fai.utb.mt_bb_app.model.BreakingBadQuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _breakingBadQuote = MutableLiveData<BreakingBadQuote>()
    val breakingBadQuote : LiveData<BreakingBadQuote> = _breakingBadQuote

    /*
    private val _text = MutableLiveData<String>().apply {
        value = breakingBadQuote.value?.quote;
    }
    val text: LiveData<String> = _text*/

    @SuppressLint("NullSafeMutableLiveData")
    fun getBBQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getBBQuote()

            var msg = result?.quote;

            if(result == null)
                msg = "null"
            else
                msg = result.quote

            Log.d("LOL", msg)
            if (result is BreakingBadQuote) {
                _breakingBadQuote.postValue(result);

            }
        }
    }
}