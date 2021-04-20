package com.dandroid.module.main

import android.app.Application
import android.util.Log.i
import com.dandroid.lib.base.BaseApplication
import com.dandroid.lib.base.module.IModuleInit
import java.util.logging.Logger

/**
 * 类描述: main组件的业务初始化
 */
class MainModuleInit : IModuleInit {

    override fun onInitAhead(application: BaseApplication?): Boolean {

        return false
    }

    override fun onInitAfter(application: BaseApplication?): Boolean {

        return false
    }
}