package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val itemList: MutableList<SaleItem>) : RecyclerView.Adapter<ItemAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    interface ItemLongClick {
        fun onLongClick(view : View, position : Int)
    }


    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClick? = null

        //바인딩
    //뷰 홀더 생성 >반환
    //onCreateViewHolder에서는 ItemViewHolder가 이너 클래스로 선언해준 ItemViewHolder를 참조 받음
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        TODO("Not yet implemented")
            //새로운 뷰를 생성 뷰 홀더에 인자로 넣어줌
        val binding  = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false) //연결 수정
        return ItemViewHolder(binding)
    }

    //  반환된 뷰 홀더에 데이터 연결
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it, position)
        }

        holder.itemView.setOnLongClickListener() OnLongClickListener@{
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }

        holder.itemImageView.setImageResource(itemList[position].Image)
        holder.tvItemTitle.text = itemList[position].ItemTitle
        holder.tvAddress.text = itemList[position].Address

        holder.tvPrice.text = itemList[position].Price



    }
    //데이터 크기 반환
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return item.size
    }

    inner class ItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
            //뷰홀더 구현
        val itemImageView = binding.iconItem
        val tvItemTitle = binding.tvItemTitle
        val tvAddress = binding.tvAddress
        val tvPrice = binding.tvPrice
        val tvItemChat = binding.tvChatCnt
        val tvItemLike = binding.tvLikecnt
        val ivAdapterLike = binding.ivLike

    }

}