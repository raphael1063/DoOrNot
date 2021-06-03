package com.robin.doornot.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robin.doornot.base.BaseViewModel
import com.robin.doornot.data.entities.TopicModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class ResultViewModel : BaseViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _positive = MutableLiveData<Boolean>()
    val positive: LiveData<Boolean> = _positive

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    private val _showResult = MutableLiveData(false)
    val showResult: LiveData<Boolean> = _showResult

    fun loadData(model: TopicModel?) {
        model?.let {
            CoroutineScope(Dispatchers.Main).launch {
                chooseAnswer(model)
                delay(3000)
                _loading.value = false
                delay(1000)
                _showResult.value = true
            }
        }
    }

    private fun chooseAnswer(model: TopicModel) {
        if(isPositive(50)) {
            _result.value = model.positiveAnswer
            _positive.value = true
        } else {
            _result.value = model.negativeAnswer
            _positive.value = false
        }
    }

    private fun isPositive(per: Int) = Random().nextInt(101) <= per
}