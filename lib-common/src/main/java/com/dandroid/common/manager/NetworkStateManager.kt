package com.dandroid.common.manager

import androidx.lifecycle.MutableLiveData

/**
 *网络变化管理者
 */
class NetworkStateManager private constructor() {

    val mNetworkStateCallback = MutableLiveData<NetState>()

    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }

}