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
     * 项目 组件
     */
    object Project {
        private const val PROJECT = "/module_project"

        /**
         * 项目 页面
         */
        const val PAGER_PROJECT = "$PROJECT/Project"
    }
}