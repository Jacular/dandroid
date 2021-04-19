package com.dandroid.module.main

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.alibaba.android.arouter.launcher.ARouter
import com.dandroid.lib.arouter.fragment.RouterFragmentPath
import com.dandroid.lib.base.BaseActivity
import com.dandroid.module.main.databinding.ModuleMainActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


open class MainActivity : BaseActivity<MainViewModel, ModuleMainActivityBinding>() {

    override fun layoutId(): Int =R.layout.module_main_activity
    private var fragments: ArrayList<Fragment> =  ArrayList()
    private var lastFragment = 0
    override fun initView(savedInstanceState: Bundle?) {
        val fragment=ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation() as Fragment
        fragments.add(fragment)
        fragments.add(ARouter.getInstance().build(RouterFragmentPath.Msg.PAGER_MSG).navigation() as Fragment)
        fragments.add(ARouter.getInstance().build(RouterFragmentPath.User.PAGER_USER).navigation() as Fragment)
        //设置fragment到布局
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).show(fragment).commit()

        mDatabind.navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_home -> {
                        //这里因为需要对3个fragment进行切换
                        //start
                        if (lastFragment !== 0) {
                            switchFragment(lastFragment, 0)
                            lastFragment = 0
                        }
                        //end
                        //如果只是想测试按钮点击，不管fragment的切换，可以把start到end里面的内容去掉
                        return true
                    }
                    R.id.navigation_dashboard -> {
                        if (lastFragment !== 1) {
                            switchFragment(lastFragment, 1)
                            lastFragment = 1
                        }
                        return true
                    }
                    R.id.navigation_notifications -> {
                        if (lastFragment !== 2) {
                            switchFragment(lastFragment, 2)
                            lastFragment = 2
                        }
                        return true
                    }
                    else -> {
                    }
                }
                return false
            }
        }

    /**
     * 切换fragment
     */
    private fun switchFragment(lastFragment: Int, index: Int) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        //隐藏上个Fragment
        transaction.hide(fragments[lastFragment])
        if (fragments[index].isAdded === false) {
            transaction.add(R.id.nav_host_fragment, fragments[index])
        }
        transaction.show(fragments[index]).commitAllowingStateLoss()
    }

    /**
     * 半透明状态栏
     */
    protected fun setHalfTransparent() {
        if (Build.VERSION.SDK_INT >= 21) { //21表示5.0
            val decorView: View = window.decorView
            val option: Int =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.setSystemUiVisibility(option)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        } else if (Build.VERSION.SDK_INT >= 19) { //19表示4.4
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //虚拟键盘也透明
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}