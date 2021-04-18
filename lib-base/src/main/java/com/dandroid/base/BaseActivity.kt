package com.dandroid.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.dandroid.base.activity.BaseVmDbActivity
import com.dandroid.base.viewmodel.BaseViewModel


/**
 * 所有子module继承这个
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>() {

    abstract override fun layoutId(): Int

    abstract override fun initView(savedInstanceState: Bundle?)

    /**
     * 创建liveData观察者
     */
    override fun createObserver() {}

    /**
     * 打开等待框
     */
    override fun showLoading(message: String) {
       // showLoadingExt(message)
    }

    /**
     * 关闭等待框
     */
    override fun dismissLoading() {
       // dismissLoadingExt()
    }

   /* *//**
     * 在任何情况下本来适配正常的布局突然出现适配失效，适配异常等问题，只要重写 Activity 的 getResources() 方法
     *//*
    override fun getResources(): Resources {
        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources())
        return super.getResources()
    }*/
}