package com.dandroid.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * ViewModel的基类 使用ViewModel类，放弃AndroidViewModel，原因：用处不大 完全有其他方式获取Application上下文
 */
open class BaseViewModel : ViewModel() {

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    /**
     * 网络请求显示隐藏loading配套
     * 内置封装好的可通知Activity/fragment 显示隐藏加载框 因为需要跟
     */
    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { MutableLiveData<String>() }
        //隐藏
        val dismissDialog by lazy { MutableLiveData<Boolean>() }
    }

}