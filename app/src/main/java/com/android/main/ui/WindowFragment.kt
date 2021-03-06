package com.android.main.ui

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.android.main.MainVM
import com.android.main.R
import com.android.main.databinding.FragmentLightBinding
import com.android.main.databinding.FragmentWindowBinding

class WindowFragment private constructor(): BaseFragment<FragmentWindowBinding>() {

    override fun getLayoutId() = R.layout.fragment_window

    private val vm by activityViewModels<MainVM>()

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
        fun instance(): WindowFragment {
            if (instance == null) instance = WindowFragment()
            return instance!!
        }
    }

}