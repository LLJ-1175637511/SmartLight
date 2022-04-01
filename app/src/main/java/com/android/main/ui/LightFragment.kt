package com.android.main.ui

import com.android.main.MainVM
import com.android.main.R
import com.android.main.databinding.FragmentLightBinding

class LightFragment private constructor(val vm: MainVM) : BaseFragment<FragmentLightBinding>() {

    override fun getLayoutId() = R.layout.fragment_light

    override fun initCreateView() {
        super.initCreateView()
        mDataBinding.btOpen.setOnClickListener {
            vm.openLight()
        }
        mDataBinding.btClose.setOnClickListener {
            vm.closeLight()
        }
    }

    companion object {
        private var instance: LightFragment? = null
        fun instance(vm: MainVM): LightFragment {
            if (instance == null) instance = LightFragment(vm)
            return instance!!
        }
    }

}