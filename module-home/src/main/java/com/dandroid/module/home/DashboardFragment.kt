package com.dandroid.module.home

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.dandroid.lib.arouter.fragment.RouterFragmentPath

import com.dandroid.lib.base.BaseFragment
import com.dandroid.module.home.databinding.ModuleHomeFragmentBinding

@Route(path = RouterFragmentPath.Home.PAGER_HOME)
class DashboardFragment : BaseFragment<DashboardViewModel, ModuleHomeFragmentBinding>() {


    override fun layoutId(): Int = R.layout.module_home_fragment

    override fun initView(savedInstanceState: Bundle?) {

    }
}