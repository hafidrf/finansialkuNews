package com.hafidrf.finansialku.ui.source

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.hafidrf.finansialku.data.repository.Repository
import com.hafidrf.finansialku.data.state.SourceState
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val state : MutableLiveData<SourceState> by lazy {
        MutableLiveData()
    }

    fun getSource(category : String){
        repository.getSources(category, state)
    }
}