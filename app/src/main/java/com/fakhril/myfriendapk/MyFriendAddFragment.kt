package com.fakhril.myfriendapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fakhril.myfriendapk.databinding.FragmentMyFriendAddBinding

class MyFriendAddFragment : Fragment() {

    private var _binding : FragmentMyFriendAddBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyFriendAddBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() {
        binding.btnSave.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsFragment()
        }
    }

    companion object {
        fun newInstance() :
            MyFriendAddFragment {
            return MyFriendAddFragment()
            }
    }
}