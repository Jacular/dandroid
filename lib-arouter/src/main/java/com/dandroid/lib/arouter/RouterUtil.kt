package com.dandroid.lib.arouter

import com.alibaba.android.arouter.launcher.ARouter
import com.dandroid.lib.arouter.activity.RouterActivityPath

object RouterUtil {
    fun launchMain() {
        ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation()
    }

//    fun launchWeb(webUrl: String?) {
//        ARouter.getInstance().build(RouterActivityPath.Web.PAGER_WEB).withString("webUrl", webUrl)
//            .navigation()
//    }

//    fun launchArticleList(id: String?, title: String?) {
//        ARouter.getInstance().build(RouterActivityPath.Square.PAGER_SQUARE_LIST)
//            .withString("id", id).withString("title", title).navigation()
//    }

    fun launchLogin() {
        ARouter.getInstance().build(RouterActivityPath.Login.PAGER_LOGIN).navigation()
    }
}