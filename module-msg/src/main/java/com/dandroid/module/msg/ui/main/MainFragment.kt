package com.dandroid.module.msg.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.dandroid.lib.arouter.fragment.RouterFragmentPath
import com.dandroid.lib.base.BaseFragment
import com.dandroid.module.msg.R
import com.dandroid.module.msg.databinding.ModuleMsgMainFragmentBinding

@Route(path = RouterFragmentPath.Msg.PAGER_MSG)
class MainFragment : BaseFragment<MainViewModel,ModuleMsgMainFragmentBinding>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun layoutId(): Int =R.layout.module_msg_main_fragment

    override fun initView(savedInstanceState: Bundle?) {

    }

}