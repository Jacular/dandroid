package com.dandroid.lib.arouter.activity

/**
 *
 */
class RouterActivityPath {
    /**
     * 登录组件
     */
    object Login {
        private const val LOGIN = "/module_login"

        /**
         * 登录页
         */
        const val PAGER_LOGIN = "$LOGIN/Login"
    }

    /**
     * Main组件
     */
    object Main {
        private const val MAIN = "/module_main"

        /**
         * 主页面
         */
        const val PAGER_MAIN =
            "$MAIN/Main"
    }
}