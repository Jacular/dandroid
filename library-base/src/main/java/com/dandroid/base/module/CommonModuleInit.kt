package com.dandroid.base.module

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.dandroid.base.BaseApplication
import com.tencent.mmkv.MMKV


/**
 * 所有子module需要在Application 初始化写在这里
 *
 */
class CommonModuleInit : IModuleInit {
    override fun onInitAhead(application: Application?): Boolean {
        MMKV.initialize(application)
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(application)

        return false
    }

    override fun onInitAfter(application: BaseApplication?): Boolean {
        return false
    }
}