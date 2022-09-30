package com.sunitawebapp.admin_giriexp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sunitawebapp.admin_giriexp.R
import com.sunitawebapp.admin_giriexp.`interface`.OnClickInterface
import com.sunitawebapp.admin_giriexp.adapter.ApprovalAdapter
import com.sunitawebapp.admin_giriexp.databinding.FragmentApprovalListBinding
import com.sunitawebapp.admin_giriexp.retrofit.Resource
import com.sunitawebapp.admin_giriexp.retrofit.models.response.ApproveListRes
import com.sunitawebapp.admin_giriexp.sharepreference.SessionManager
import com.sunitawebapp.admin_giriexp.utils.MyDialog
import com.sunitawebapp.admin_giriexp.viewmodels.ApprovalListViewModel


class ApprovalListFragment : Fragment() {
    lateinit var binding : FragmentApprovalListBinding
    val approvalListViewModel : ApprovalListViewModel by viewModels()
    var approveListRes = ApproveListRes()
    var approvalAdapter= ApprovalAdapter(approveListRes)

   // var approveListResItem : MutableList<ApproveListResItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentApprovalListBinding.inflate(inflater, container, false)
        binding.apply {
        //    btnLogin.setOnClickListener(this@LoginFragment)
            return binding.root
        }
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        approvalAdapter.onClickRecylerView(object   : OnClickInterface{
            override fun onClickRecyclerViewItem(position: Int) {
              var fullName=  approveListRes.get(position).fullName
               var mobile= approveListRes.get(position).mobile
             var stationName=   approveListRes.get(position).stationName
             ApprovalListFragmentDirections.actionApprovalListFragmentToVerifyRegisterFragment(fullName,mobile,stationName)
               findNavController().navigate(R.id.verifyRegisterFragment)
            }

        })

        var sessionManager=SessionManager(requireContext())
        approvalListViewModel.ApprovalList(sessionManager.getuserloginid(),sessionManager.getusertypeid())
        approvalListViewModel.ApprovalListLivedata.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success->{
                    approveListRes.clear()
                    MyDialog.stopLoading()

                    approveListRes.addAll(it.data!!)
                    approvalAdapter.notifyDataSetChanged()
                 binding. rvapproveList.adapter=approvalAdapter


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

}