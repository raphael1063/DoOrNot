package com.robin.doornot.ui.main


import com.robin.doornot.R
import com.robin.doornot.BR
import com.robin.doornot.base.BaseActivity
import com.robin.doornot.data.entities.TopicModel
import com.robin.doornot.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutRes = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()
    override val viewModelVariable = BR.vm
    private val adapter by lazy {
        MainAdapter(viewModel)
    }

    override fun start() {
        binding.rvTopic.adapter = adapter
        adapter.submitList(mutableListOf(TopicModel("1"), TopicModel("2"), TopicModel("3")))
    }

    override fun observe() {
    }
}