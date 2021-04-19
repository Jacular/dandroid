package com.dandroid.module.home

import com.dandroid.base.BaseApplication
import com.dandroid.base.module.ModuleLifecycleConfig

/**
 */
class ModuleHomeApp : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        ModuleLifecycleConfig.instance.initModuleAhead(this)
    }
}