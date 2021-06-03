package com.robin.doornot.ui.main


import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
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

        MobileAds.initialize(this)

        binding.adView.loadAd(AdRequest.Builder().build())

        binding.rvTopic.adapter = adapter
        adapter.submitList(
            mutableListOf(
                TopicModel(resources.getString(R.string.doOrNot), resources.getString(R.string.doIt), resources.getString(R.string.dontDoIt)),
                TopicModel(resources.getString(R.string.buyOrNot), resources.getString(R.string.buyIt), resources.getString(R.string.dontBuyIt)),
                TopicModel(resources.getString(R.string.eatOrNot), resources.getString(R.string.eatIt), resources.getString(R.string.dontEatIt)),
                TopicModel(resources.getString(R.string.giveOrNot), resources.getString(R.string.giveIt), resources.getString(R.string.dontGiveIt)),
                TopicModel(resources.getString(R.string.goOrNot), resources.getString(R.string.go), resources.getString(R.string.dontGo))
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