package com.dandroid.lib.base.module

import android.app.Application
import com.dandroid.lib.base.BaseApplication

/**
 * 管理module
 */
class ModuleLifecycleConfig private constructor() {
    var initModuleNames =
        arrayOf<String>("com.dandroid.lib.base.module.CommonModuleInit")
    private object SingleHolder {
        val instance = ModuleLifecycleConfig()
    }

    /**
     * 优先初始化
     */
    fun initModuleAhead(application: Application?) {
        for (moduleName in initModuleNames) {
            try {
                val clazz = Class.forName(moduleName)
                val init = clazz.newInstance() as IModuleInit
                init.onInitAhead(application)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 后初始化
     */
    fun initModuleAfter(application: BaseApplication?) {
        for (moduleName in initModuleNames) {
            try {
                val clazz = Class.forName(moduleName)
                val init = clazz.newInstance() as IModuleInit
                // 调用初始化方法
                init.onInitAfter(application)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        val instance: ModuleLifecycleConfig
            get() = SingleHolder.instance
    }
}