package com.dandroid.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ModelHomeActivity : AppCompatActivity() {

    //双重校验锁式-单例
//    val apiService: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//        NetworkApi.INSTANCE.getApi(ApiService::class.java, BuildConfig.BASE_URL_DEV)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_home_fragment)
      
    }
}