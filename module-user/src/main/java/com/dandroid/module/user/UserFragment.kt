package com.dandroid.module.user

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.dandroid.lib.arouter.fragment.RouterFragmentPath
import com.dandroid.lib.base.BaseFragment
import com.dandroid.module.user.databinding.ModuleUserFragmentBinding

@Route(path = RouterFragmentPath.User.PAGER_USER)
class UserFragment : BaseFragment<UserViewModel,ModuleUserFragmentBinding>() {

    companion object {
        fun newInstance() = UserFragment()
    }

    override fun layoutId(): Int =R.layout.module_user_fragment

    override fun initView(savedInstanceState: Bundle?) {

    }

}