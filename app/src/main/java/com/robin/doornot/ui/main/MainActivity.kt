package com.robin.doornot.ui.main


import com.robin.doornot.R
import com.robin.doornot.BR
import com.robin.doornot.base.BaseActivity
import com.robin.doornot.data.entities.TopicModel
import com.robin.doornot.databinding.ActivityMainBinding
import com.robin.doornot.ext.openActivity
import com.robin.doornot.ui.result.ResultActivity
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
        adapter.submitList(
            mutableListOf(
                TopicModel("할까...말까?", "해라", "하지 마라"),
                TopicModel("살까...말까?", "사라", "사지 마라"),
                TopicModel("먹을까...말까?", "먹어라", "먹지 마라"),
                TopicModel("줄까...말까?", "줘라", "주지 마라"),
                TopicModel("갈까...말까?", "가라", "가지 마라")
            )
        )
    }

    override fun observe() {
        with(viewModel) {
            goResult.observe(this@MainActivity, { event ->
                event?.getContentIfNotHandled()?.let {
                    openActivity(ResultActivity::class.java){
                        putParcelable("MODEL", it)
                    }
                }
            })
        }
    }
}