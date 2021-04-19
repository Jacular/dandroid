package com.dandroid.lib.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.dandroid.lib.base.manage.ActivityManage.addActivity
import com.dandroid.lib.base.manage.ActivityManage.removeActivity

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setApplication(this)
    }

    /**
     * 当宿主没有继承自该Application时,可以使用set方法进行初始化baseApplication
     */
    private fun setApplication(application: BaseApplication) {
        instance = application
        application
            .registerActivityLifecycleCallbacks(object :
                ActivityLifecycleCallbacks {
                override fun onActivityCreated(
                    activity: Activity,
                    savedInstanceState: Bundle?
                ) {
                    addActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {}
                override fun onActivityResumed(activity: Activity) {}
                override fun onActivityPaused(activity: Activity) {}
                override fun onActivityStopped(activity: Activity) {}
                override fun onActivitySaveInstanceState(
                    activity: Activity, outState: Bundle
                ) {
                }

                override fun onActivityDestroyed(activity: Activity) {
                    removeActivity(activity)
                }
            })
    }

    companion object {
        private var instance: BaseApplication? = null

        /**
         * 获得当前app运行的Application
         */
        fun getInstance(): BaseApplication? {
            if (instance == null) {
                throw NullPointerException(
                    "please inherit BaseApplication or call setApplication."
                )
            }
            return instance
        }
    }
}