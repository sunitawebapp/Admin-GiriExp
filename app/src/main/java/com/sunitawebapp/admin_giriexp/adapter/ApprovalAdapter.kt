package com.sunitawebapp.admin_giriexp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunitawebapp.admin_giriexp.`interface`.OnClickInterface
import com.sunitawebapp.admin_giriexp.databinding.ItemApprovalListBinding
import com.sunitawebapp.admin_giriexp.retrofit.models.response.ApproveListRes
import com.sunitawebapp.admin_giriexp.retrofit.models.response.ApproveListResItem

class ApprovalAdapter(var res: ApproveListRes): RecyclerView.Adapter<ApprovalAdapter.ApprovalViewHolder> (){
    lateinit var onClickInterface : OnClickInterface
    class ApprovalViewHolder(var binding: ItemApprovalListBinding) : RecyclerView.ViewHolder(binding.root) {
      fun setBinding (item: ApproveListResItem){
          binding.approveListResItem=item
      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApprovalViewHolder {
      return ApprovalViewHolder(ItemApprovalListBinding.inflate(  LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ApprovalViewHolder, position: Int) {
      holder.setBinding(res[position])

        holder.itemView.setOnClickListener {
            onClickInterface.onClickRecyclerViewItem(position)
        }
    }

    override fun getItemCount(): Int {
    return  res.size
    }


    fun onClickRecylerView( onClickInterface : OnClickInterface){
     this.onClickInterface=onClickInterface

    }


}