package com.robin.doornot.ui.result

import com.robin.doornot.R
import com.robin.doornot.BR
import com.robin.doornot.base.BaseActivity
import com.robin.doornot.databinding.ActivityResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultActivity : BaseActivity<ActivityResultBinding, ResultViewModel>() {

    override val layoutRes = R.layout.activity_result
    override val viewModel: ResultViewModel by viewModel()
    override val viewModelVariable = BR.vm

    override fun start() {

    }

    override fun observe() {

    }
}