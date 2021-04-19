package com.dandroid.lib.base.manage

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * 管理activity
 */
object ActivityManage {
    private val activityStack =
        Stack<Activity>()

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        activityStack.push(activity)
    }

    fun removeActivity(activity: Activity?) {
        activityStack.remove(activity)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishCurrentActivity() {
        val activity = activityStack.pop()
        activity.finish()
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        if (activity != null) {
//            activityStack.remove(activity);
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }

    fun finishExcept(cls: Class<*>) {
        for (activity in activityStack) {
            if (activity.javaClass != cls) {
                finishActivity(activity)
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                finishActivity(activity)
            }
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity?.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出应用程序
     */
    fun appExit(context: Context) {
        try {
            finishAllActivity()
            val manager = context
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            manager.killBackgroundProcesses(context.packageName)
            System.exit(0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}