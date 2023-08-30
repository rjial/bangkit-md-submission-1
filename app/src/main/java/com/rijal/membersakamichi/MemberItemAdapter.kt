package com.rijal.membersakamichi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rijal.membersakamichi.databinding.ItemCardBinding

class MemberItemAdapter(val listMember: ArrayList<MemberSaka>): RecyclerView.Adapter<MemberItemAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listMember.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val member: MemberSaka = listMember[position]
        val binding = holder.binding
        binding.imgMember.setImageResource(member.image)
        binding.txtSecondMember.text = "${member.getGroup()} - ${member.getGeneration()}"
        binding.txtNamaMember.text = member.name
        binding.txtDescMember.text = member.desc
    }
}