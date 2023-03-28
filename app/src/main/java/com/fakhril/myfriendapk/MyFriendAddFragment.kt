package com.fakhril.myfriendapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.fakhril.myfriendapk.databinding.FragmentMyFriendAddBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MyFriendAddFragment : Fragment() {

    private var _binding : FragmentMyFriendAddBinding? = null
    private val binding get() = _binding!!

    private var namaInput : String = ""
    private var emailInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var genderInput : String = ""

    private var db: MyFriendDatabase? = null
    private var myFriendDao : MyFriendDao? = null


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
        initDB()
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() {
        binding.btnSave.setOnClickListener {
            validation()
        }

        setDataSpinnerGender()
    }


    private fun initDB() {
        db = MyFriendDatabase.getAppDatabase(requireActivity())
        myFriendDao = db?.myFriendDao()
    }

    private fun validation(){
        namaInput = binding.edtName.text.toString()
        emailInput = binding.edtEmail.text.toString()
        telpInput = binding.edtTelp.text.toString()
        alamatInput = binding.edtAddres.text.toString()
        genderInput = binding.spinnerGender.selectedItem.toString()

        when{
            namaInput.isEmpty() -> binding.edtName.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Kelamin") -> tampilToast("Kelamin Harus Dipilih")
            emailInput.isEmpty() -> binding.edtEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> binding.edtTelp.error = "Telepon tidak boleh kosong"
            alamatInput.isEmpty() -> binding.edtAddres.error = "Alamat tidak boleh kosong"

            else -> {
                val teman = MyFriend(nama = namaInput, kelamin = genderInput, email = emailInput, telp = telpInput, alamat = alamatInput)

                tambahDataTeman(teman)
            }
        }
    }

    private fun tambahDataTeman(teman: MyFriend) : Job {
        return GlobalScope.launch {
            myFriendDao?.tambahTeman(teman)
            (activity as MainActivity).tampilMyFriendsFragment()
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(requireActivity(), R.array.gender_list, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerGender.adapter = adapter
    }
    companion object {
        fun newInstance() :
            MyFriendAddFragment {
            return MyFriendAddFragment()
            }
    }
}