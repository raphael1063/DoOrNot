package com.robin.doornot.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.robin.doornot.R
import com.robin.doornot.BR
import com.robin.doornot.base.BaseActivity
import com.robin.doornot.databinding.ActivitySplashBinding
import com.robin.doornot.ext.openActivity
import com.robin.doornot.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity: BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val layoutRes = R.layout.activity_splash
    override val viewModel: SplashViewModel by viewModel()
    override val viewModelVariable = BR.vm

    override fun start() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            openActivity(MainActivity::class.java)
            finishAffinity()
        }
    }

    override fun observe() {
    }
}