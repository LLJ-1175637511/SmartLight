package com.android.main.ui

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.android.main.MainVM
import com.android.main.R
import com.android.main.databinding.FragmentLightBinding

class LightFragment private constructor() : BaseFragment<FragmentLightBinding>() {

    override fun getLayoutId() = R.layout.fragment_light

    private val vm by activityViewModels<MainVM>()

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
        fun instance(): LightFragment {
            if (instance == null) instance = LightFragment()
            return instance!!
        }
    }

}