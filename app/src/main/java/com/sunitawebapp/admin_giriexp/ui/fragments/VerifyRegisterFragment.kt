package com.sunitawebapp.admin_giriexp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.sunitawebapp.admin_giriexp.R
import com.sunitawebapp.admin_giriexp.databinding.FragmentVerifyRegisterBinding


class VerifyRegisterFragment : Fragment(), OnClickListener {
   lateinit var binding : FragmentVerifyRegisterBinding
   var clickApproveName =false
    var clickApproveMob =false
    var clickApproveStation =false

    lateinit var verifyRegisterFragmentArgs : VerifyRegisterFragmentArgs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentVerifyRegisterBinding.inflate(inflater,container, false)
        binding.apply {
            imgNameApprove.setOnClickListener(this@VerifyRegisterFragment)
            imgMobileApprove.setOnClickListener(this@VerifyRegisterFragment)
            imgStationApprove.setOnClickListener(this@VerifyRegisterFragment)
            btnApprove.setOnClickListener(this@VerifyRegisterFragment)
            btnReject.setOnClickListener(this@VerifyRegisterFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.imgNameApprove ->{
                if (!clickApproveName) {
                    clickApproveName=true
                    binding.imgNameApprove.setBackgroundResource(R.drawable.tick_icon)
                }else{
                    clickApproveName=false
                    binding.imgNameApprove.setBackgroundResource(R.drawable.untick_icon)
                }
            }

            binding.imgMobileApprove ->{
                if (!clickApproveMob) {
                    clickApproveMob=true
                    binding.imgMobileApprove.setBackgroundResource(R.drawable.tick_icon)
                }else{
                    clickApproveMob=false
                    binding.imgMobileApprove.setBackgroundResource(R.drawable.untick_icon)
                }
            }

            binding.imgStationApprove ->{
                if (!clickApproveStation) {
                    clickApproveStation=true
                    binding.imgStationApprove.setBackgroundResource(R.drawable.tick_icon)
                }else{
                    clickApproveStation=false
                    binding.imgStationApprove.setBackgroundResource(R.drawable.untick_icon)
                }
            }

            binding.btnApprove->{

            }

            binding.btnReject->{

            }
        }
    }

}