package com.dandroid.lib.arouter.fragment

/**
 *
 */
class RouterFragmentPath {
    /**
     * 首页组件
     */
    object Home {
        private const val HOME = "/module_home"

        /**
         * 首页
         */
        const val PAGER_HOME = "$HOME/Home"
    }

    /**
     * 消息 组件
     */
    object Msg {
        private const val MSG = "/module_msg"

        /**
         * 消息 页面
         */
        const val PAGER_MSG = "$MSG/Msg"
    }

    /**
     * 我的 组件
     */
    object User {
        private const val USER = "/module_user"

        /**
         * 我的 页面
         */
        const val PAGER_USER = "$USER/User"
    }
}