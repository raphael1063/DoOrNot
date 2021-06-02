package com.robin.doornot.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robin.doornot.base.BaseViewModel
import com.robin.doornot.data.entities.TopicModel
import com.robin.doornot.util.Event

class MainViewModel : BaseViewModel() {

    private val _goResult = MutableLiveData<Event<TopicModel>>()
    val goResult: LiveData<Event<TopicModel>> = _goResult

    fun onItemClicked(model: TopicModel){
        _goResult.value = Event(model)
    }
}