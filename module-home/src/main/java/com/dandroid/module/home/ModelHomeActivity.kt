package com.dandroid.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dandroid.module.home.request.ApiService
import com.dandroid.network.NetworkApi

class ModelHomeActivity : AppCompatActivity() {

    //双重校验锁式-单例
    val apiService: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        NetworkApi.INSTANCE.getApi(ApiService::class.java, BuildConfig.BASE_URL_DEV)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model_home)
      
    }
}