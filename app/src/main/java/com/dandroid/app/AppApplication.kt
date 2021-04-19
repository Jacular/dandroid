package com.dandroid.app

import com.dandroid.lib.base.BaseApplication
import com.dandroid.lib.base.module.ModuleLifecycleConfig

/**
 * 应用模块: 宿主app
 *
 *initModuleAhead进行相应初始化(通过反射调用各个组件的初始化器)
 */
class AppApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        // 初始化需要初始化的组件
        ModuleLifecycleConfig.instance.initModuleAhead(this)
    }
}