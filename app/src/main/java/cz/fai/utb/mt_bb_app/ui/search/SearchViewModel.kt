package cz.fai.utb.mt_bb_app.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Zatím tu nic není. :("
    }
    val text: LiveData<String> = _text
}