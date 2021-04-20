package com.dandroid.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dandroid.lib.base.BaseActivity
import com.dandroid.module.home.databinding.ModuleHomeFragmentBinding

class ModelHomeActivity : BaseActivity<DashboardViewModel,ModuleHomeFragmentBinding>() {

    //双重校验锁式-单例
//    val apiService: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//        NetworkApi.INSTANCE.getApi(ApiService::class.java, BuildConfig.BASE_URL_DEV)
//    }

    override fun layoutId(): Int =R.layout.module_home_fragment

    override fun initView(savedInstanceState: Bundle?) {

    }
}