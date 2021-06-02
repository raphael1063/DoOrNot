package com.robin.doornot.ui.result

import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.robin.doornot.R
import com.robin.doornot.BR
import com.robin.doornot.base.BaseActivity
import com.robin.doornot.databinding.ActivityResultBinding
import com.robin.doornot.ext.openActivity
import com.robin.doornot.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultActivity : BaseActivity<ActivityResultBinding, ResultViewModel>() {

    override val layoutRes = R.layout.activity_result
    override val viewModel: ResultViewModel by viewModel()
    override val viewModelVariable = BR.vm

    override fun start() {
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            binding.lottieLoading.startAnimation(fadeOut)
            binding.tvLoading.startAnimation(fadeOut)
            binding.lottieLoading.isVisible = false
            binding.tvLoading.isVisible = false

            delay(1000)

            binding.tvResultText.startAnimation(fadeIn)
            binding.viewResultBackground.startAnimation(fadeIn)
            binding.tvResultText.isVisible = true
            binding.viewResultBackground.isVisible = true
        }

    }

    override fun observe() {

    }
}