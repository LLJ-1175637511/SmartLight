package com.android.main.ui

import com.android.main.MainVM
import com.android.main.R
import com.android.main.databinding.FragmentLightBinding
import com.android.main.databinding.FragmentWindowBinding

class WindowFragment private constructor(val vm: MainVM): BaseFragment<FragmentWindowBinding>() {

    override fun getLayoutId() = R.layout.fragment_window

    override fun initCreateView() {
        super.initCreateView()
        mDataBinding.btOpen.setOnClickListener {
            vm.openWindow()
        }
        mDataBinding.btClose.setOnClickListener {
            vm.closeWindow()
        }
    }

    companion object {
        private var instance: WindowFragment? = null
        fun instance(vm: MainVM): WindowFragment {
            if (instance == null) instance = WindowFragment(vm)
            return instance!!
        }
    }

}