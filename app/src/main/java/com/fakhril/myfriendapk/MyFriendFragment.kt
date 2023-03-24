package com.fakhril.myfriendapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fakhril.myfriendapk.databinding.FragmentMyFriendBinding


class MyFriendFragment : Fragment() {

    private var _binding : FragmentMyFriendBinding? = null
    private val binding get() = _binding!!

    private var listTeman : List<MyFriend>? = null

    private var db : MyFriendDatabase? = null
    private var myFriendDao : MyFriendDao? = null

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
        initDB()
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

        getFriendData()
    }

    private fun getFriendData() {
        listTeman = ArrayList()
        myFriendDao?.getAllData()?.observe(viewLifecycleOwner, Observer {
            data -> listTeman = data

            when{
                listTeman?.size == 0 -> tampilToast("Belum ada data teman")
                else -> {
                    tampilTeman()
                }
            }
        })
    }



    private fun initDB() {
        db = MyFriendDatabase.getAppDatabase(requireActivity())
        myFriendDao = db?.myFriendDao()
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    private fun tampilTeman() {
        binding.listMyFriends.layoutManager = LinearLayoutManager(requireActivity())
        binding.listMyFriends.adapter = MyFriendAdapter(requireActivity(),
            listTeman!! as ArrayList<MyFriend>
        )
    }
    companion object {
        fun newInstance() :
            MyFriendFragment {
                return MyFriendFragment()
            }
    }
}