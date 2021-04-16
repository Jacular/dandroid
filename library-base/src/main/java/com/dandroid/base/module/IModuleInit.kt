package com.dandroid.base.module

import android.app.Application
import com.dandroid.base.BaseApplication

/**
 * 统一在宿主app 的Application进行初始化
 */
interface IModuleInit {
    /**
     * 需要优先初始化的
     */
    fun onInitAhead(application: Application?): Boolean

    /**
     * 可以后初始化的
     */
    fun onInitAfter(application: BaseApplication?): Boolean
}