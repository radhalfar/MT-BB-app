package cz.fai.utb.mt_bb_app.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.fai.utb.mt_bb_app.Repository
import cz.fai.utb.mt_bb_app.model.BreakingBadQuote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _breakingBadQuote = MutableLiveData<BreakingBadQuote>()
    val breakingBadQuote : LiveData<BreakingBadQuote> = _breakingBadQuote

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name="Favourites")



    init {

    }

    @SuppressLint("NullSafeMutableLiveData")
    fun getBBQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getBBQuote()

            if (result is BreakingBadQuote) {
                _breakingBadQuote.postValue(result);

            }
        }
    }

    fun addToFavQuotes() {
        viewModelScope.launch(Dispatchers.IO) {
           /*context.dataStore.edit { favourites ->
               val currentCounterValue = favourites["pocitadlo"] ?: 0
               favourites["pocitadlo"] = currentCounterValue + 1

           }

            Log.d("FavoriteQuotes", "All Favorite Quotes:\n$allQuotes")*/
        }
    }
}