package com.shoppi.app.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shoppi.app.R
import com.shoppi.app.databinding.ItemHomeBannerBinding
import com.shoppi.app.home.data.Banner

class HomeBannerAdapter :
    ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        //뷰 생성
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
        val binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //뷰홀더 생성후에 뷰를 넘겨줌, 바인딩이랑
        return HomeBannerViewHolder(binding)
    }

    //ViewHolder에 데이터를 바인딩, ViewHolder가 전달
    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        //ListAdapter에서 제공하는 getItem(position)을 통해 데이터를 가져옴
        holder.bind(getItem(position))
    }

    //inflate한 뷰를 ViewHolder에 넘겨줌
    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            // ViewBinding을 사용하여 뷰에 데이터 바인딩
            with(binding) {
               ivBannerImage.load(banner.backgroundImageUrl)
            }
        }
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }
}