package com.sunitawebapp.admin_giriexp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sunitawebapp.admin_giriexp.R
import com.sunitawebapp.admin_giriexp.databinding.FragmentLoginBinding
import com.sunitawebapp.admin_giriexp.retrofit.models.Request.LoginReq
import com.sunitawebapp.admin_giriexp.retrofit.Resource
import com.sunitawebapp.admin_giriexp.sharepreference.SessionManager
import com.sunitawebapp.admin_giriexp.utils.MyDialog
import com.sunitawebapp.admin_giriexp.viewmodels.LoginViewModel

class LoginFragment : Fragment() ,View.OnClickListener{
    lateinit var binding : FragmentLoginBinding
    private val loginViewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding=FragmentLoginBinding.inflate(inflater, container, false)
         binding.apply {
             btnLogin.setOnClickListener(this@LoginFragment)
             return binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginViewModel.loginLiveData.observe(viewLifecycleOwner){res->
            when(res) {
                is Resource.Success -> {
                    res.data?.let {
                        MyDialog.stopLoading()
                        if (res.data.status.toString()=="1"){
                           var sessionManager=SessionManager(requireContext())
                            sessionManager.setusertypeid(res.data.tblmastusertype_id)
                            sessionManager.setuserloginid(res.data.tblsysuserlogin_id)
                            Toast.makeText(requireContext(), "login suncess", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.homeFragment)

                        }else{
                              Toast.makeText(requireContext(), "login unsuncess", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.loginFragment)
                        }

                    }
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {
                    MyDialog.showLoading(requireContext())
                }
            }
        }

        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnLogin->{
                loginViewModel.login(
                 LoginReq(
                     password=binding.etnPassword.text.toString(),
                     userName=binding.etnMobNo.text.toString(),
                     userTypeID=1
                 )
                )

            }
        }
    }
}
