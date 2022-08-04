package com.example.nitrixtesttask.ui.videos_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.repository.api.Constants.Companion.BASE_IMAGE_URL
import com.example.nitrixtesttask.ui.videos_list.model.VideoItem
import kotlinx.android.synthetic.main.video_list_item.view.*

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {

    private var videosList: List<VideoItem> = mutableListOf()

    inner class VideosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.video_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return videosList.size
    }


    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(this).load(BASE_IMAGE_URL + videosList[position].prevImageUrl).centerCrop()
                .into(ivVideoPreview)
            tvVideoTitle.text = videosList[position].title
            tvVideoSubtitle.text = videosList[position].subtitle
            tvVideoDesc.text = videosList[position].description
            setOnClickListener {
                findNavController().navigate(R.id.action_videosListFragment_to_videoFragment)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<VideoItem>) {
        videosList = list
        notifyDataSetChanged()
    }

}