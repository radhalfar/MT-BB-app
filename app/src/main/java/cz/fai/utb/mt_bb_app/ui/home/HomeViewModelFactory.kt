package cz.fai.utb.mt_bb_app.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cz.fai.utb.mt_bb_app.Repository

class HomeViewModelFactory (
    private val repository: Repository
) : ViewModelProvider.Factory
{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                Log.d("FUCK THIS SHIT IM OUT", "THIS IS HAPPENING")
                return HomeViewModel(repository) as T
            }
            throw IllegalArgumentException("Wrong ViewModel class")
        }
}