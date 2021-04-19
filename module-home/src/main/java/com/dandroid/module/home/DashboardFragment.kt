package com.dandroid.module.home

import android.os.Bundle

import com.dandroid.base.BaseFragment

class DashboardFragment : BaseFragment<DashboardViewModel, Dash>() {

    private lateinit var dashboardViewModel: DashboardViewModel


    override fun layoutId(): Int =R.layout.activity_model_home

    override fun initView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }
}