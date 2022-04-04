package com.hafidrf.finansialku.ui.search

import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent
import com.jakewharton.rxbinding3.widget.textChangeEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import com.hafidrf.finansialku.data.model.news.DataNews
import com.hafidrf.finansialku.data.repository.Repository
import com.hafidrf.finansialku.data.state.NewsState
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by : com.hafidrf.finansialku
 */

@HiltViewModel
class SearchViewModel @Inject constructor(
    val repository : Repository
): ViewModel() {

    val state : MutableLiveData<NewsState> by lazy {
        MutableLiveData<NewsState>()
    }

    val data : MutableLiveData<PagedList<DataNews>> by lazy {
        MutableLiveData<PagedList<DataNews>>()
    }

    fun setupSearchNews(editText: EditText, owner: LifecycleOwner){
        editText.textChangeEvents()
            .skipInitialValue()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<TextViewTextChangeEvent>() {
                override fun onNext(t: TextViewTextChangeEvent) {
                    val keyword = t.text.toString()
                    if(keyword.trim{it <= ' '}.isNotEmpty() && keyword.trim{it <= ' '}.length >= 2) {
                        repository.searchNews(keyword, state, data, owner)
                    }
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
            .let { return@let repository.getDisposable()::add }
    }
}