package com.fakhril.myfriendapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fakhril.myfriendapk.databinding.FragmentMyFriendBinding


class MyFriendFragment : Fragment() {

    private var _binding : FragmentMyFriendBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyFriendBinding.inflate(inflater, container, false)
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

    private fun initView(){
        binding.btnFAB.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsAddFragment()
        }
    }


    companion object {
        fun newInstance() :
            MyFriendFragment {
                return MyFriendFragment()
            }
    }
}