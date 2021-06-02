package com.robin.doornot.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel>(
) : AppCompatActivity() {

    lateinit var binding: VB
    abstract val layoutRes: Int
    abstract val viewModel: VM
    abstract val viewModelVariable: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        with(binding) {
            lifecycleOwner = this@BaseActivity
            setVariable(viewModelVariable, viewModel)
        }
        start()
        observe()
    }

    abstract fun start()
    abstract fun observe()
}