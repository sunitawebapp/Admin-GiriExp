package com.sunitawebapp.admin_giriexp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sunitawebapp.admin_giriexp.R
import com.sunitawebapp.admin_giriexp.databinding.FragmentHomeBinding
import com.sunitawebapp.admin_giriexp.retrofit.models.response.UserCountResItem
import com.sunitawebapp.admin_giriexp.retrofit.Resource
import com.sunitawebapp.admin_giriexp.utils.MyDialog
import com.sunitawebapp.admin_giriexp.viewmodels.TotalUserCountViewModel


class HomeFragment : Fragment() ,OnClickListener{
     lateinit var binding : FragmentHomeBinding
     val totalUserCountViewModel : TotalUserCountViewModel by viewModels()

    var userCountResItem : MutableList<UserCountResItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        binding.apply {
            btnVerifyRegister.setOnClickListener(this@HomeFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        totalUserCountViewModel.UserCount()
        totalUserCountViewModel.totalUserCountLivedata.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success->{
                    MyDialog.stopLoading()
                    for (i in it.data!!) {
                        userCountResItem.add(i)
                        binding.tvIC.text = it.data.get(0).userCount.toString()

                        binding.tvExployee.text = it.data.get(1).userCount.toString()
                        binding.tvManagers.text = it.data.get(2).userCount.toString()

                    }

                }
                is Resource.Loading->{
                 MyDialog.showLoading(requireContext())
                }
                is Resource.Error->{

                }
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(view: View?) {
        when(view){
          binding. btnVerifyRegister->{
           findNavController().navigate(R.id.approvalListFragment)
          }
        }
    }
}
