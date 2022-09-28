package com.sunitawebapp.admin_giriexp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.sunitawebapp.admin_giriexp.BuildConfig
import com.sunitawebapp.admin_giriexp.R
import com.sunitawebapp.admin_giriexp.databinding.FragmentSplashBinding
import com.sunitawebapp.admin_giriexp.retrofit.Resource
import com.sunitawebapp.admin_giriexp.utils.MyDialog
import com.sunitawebapp.admin_giriexp.viewmodels.AppVersionAvailableViewmodel
import retrofit2.Response


class SplashFragment : Fragment() {
 lateinit var binding : FragmentSplashBinding
 private val appVersionAvailableViewmodel : AppVersionAvailableViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding=FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.splashVersion.setText("Version " + BuildConfig.VERSION_NAME)
        appVersionAvailableViewmodel.isUpdateAvailable()
        appVersionAvailableViewmodel.appVersionAvailLivedata.observe(viewLifecycleOwner){res->
            when(res){
                is Resource.Success->{
                  res.data?.let {
                      MyDialog.stopLoading()
                      if(BuildConfig.VERSION_NAME!=res.data.dbVersion) {
                          findNavController().navigate(R.id.versionAvailableFragment)
                      }
                else{
                          val secondsDelayed = 1
                          Handler().postDelayed({

                              findNavController().navigate(R.id.loginFragment)

                          }, (secondsDelayed * 2000).toLong())
}
                  }
                }
                is Resource.Error->{

                }
                is Resource.Loading->{
                   MyDialog.showLoading(requireContext())
                }
            }
        }



        super.onViewCreated(view, savedInstanceState)
    }
}
