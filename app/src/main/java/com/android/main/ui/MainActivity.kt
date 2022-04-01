package com.android.main.ui

import android.annotation.SuppressLint
import android.os.Build
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentTransaction
import com.android.main.MainDataBean
import com.android.main.MainVM
import com.android.main.R
import com.android.main.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.llj.baselib.IOTViewModel
import com.llj.baselib.ui.IOTMainActivity
import com.llj.baselib.utils.ToastUtils

class MainActivity : IOTMainActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    private val vm by viewModels<MainVM>()

    private val tabList = arrayOf("开关", "滑动", "窗帘")

    override fun init() {
        super.init()
//        vm.connect(this, MainDataBean::class.java)
        initMainView()
    }

    private fun initMainView() {
        initTab()
        mDataBinding.btAllClose.setOnClickListener {
            vm.closeAllLight()
        }
    }

    private fun initTab() {
        mDataBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.customView == null) {
                    tab.setCustomView(R.layout.tab_text)
                }
                val t = tab.customView?.findViewById<TextView>(R.id.tab_text)
                t?.setTextAppearance(R.style.TabLayoutTextSelected)
                t?.text = tabList[tab.position]
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTabUnselected(tab: TabLayout.Tab) {
                if (tab.customView == null) {
                    tab.setCustomView(R.layout.tab_text)
                }
                val t = tab.customView?.findViewById<TextView>(R.id.tab_text)
                t?.setTextAppearance(R.style.TabLayoutTextUnSelected)
                t?.text = tabList[tab.position]
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

        tabList.forEach {
            val newTab = mDataBinding.tabLayout.newTab()
            newTab.setText(it)
            mDataBinding.tabLayout.addTab(newTab)
        }
        mDataBinding.viewPager.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int {
                return tabList.size
            }

            override fun getItem(position: Int): Fragment {
                when (position) {
                    0 -> return LightFragment.instance(vm)
                    1 -> return ScrollFragment.instance(vm)
                    2 -> return WindowFragment.instance(vm)
                    else -> return Fragment()
                }
            }

            override fun getPageTitle(position: Int): CharSequence {
                return tabList[position]
            }
        }
        mDataBinding.tabLayout.setupWithViewPager(mDataBinding.viewPager, false);
    }


    @SuppressLint("ResourceAsColor")
    override fun offDevLine() {
        mDataBinding.tvDevState.setTextColor(R.color.red)
        mDataBinding.tvDevState.text = "设备离线"
    }

    @SuppressLint("ResourceAsColor")
    override fun onDevLine() {
        mDataBinding.tvDevState.setTextColor(R.color.greenDark)
        mDataBinding.tvDevState.text = "设备在线"
    }

    override fun realData(data: Any?) {
        ToastUtils.toastShort("data:${(data as MainDataBean).toString()}")
    }

    override fun webState(state: IOTViewModel.WebSocketType) {
    }

}