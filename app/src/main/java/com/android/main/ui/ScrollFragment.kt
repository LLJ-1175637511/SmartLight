package com.android.main.ui

import android.annotation.SuppressLint
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.android.main.MainVM
import com.android.main.R
import com.android.main.databinding.FragmentScrollBinding
import com.llj.baselib.utils.LogUtils

class ScrollFragment private constructor(): BaseFragment<FragmentScrollBinding>() {

    override fun getLayoutId() = R.layout.fragment_scroll

    private val vm by activityViewModels<MainVM>()

    override fun initCreateView() {
        super.initCreateView()
        mDataBinding.seekbar.setOnSeekBarChangeListener(@SuppressLint("AppCompatCustomView")
        object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                LogUtils.d("progress","seek:${p0?.progress}")
                val p = p0?.progress ?: 0
                vm.scrollLight(p)
            }

        })
    }

    companion object {
        private var instance: ScrollFragment? = null
        fun instance(): ScrollFragment {
            if (instance == null) instance = ScrollFragment()
            return instance!!
        }
    }

}