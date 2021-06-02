package com.robin.doornot.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.robin.doornot.R
import com.robin.doornot.data.entities.TopicModel
import com.robin.doornot.databinding.ItemTopicBinding

class MainAdapter(private val viewModel: MainViewModel) :
    ListAdapter<TopicModel, MainAdapter.TopicViewHolder>(TOPIC_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder =
        TopicViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_topic, parent, false))

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(viewModel, currentList[position])
    }


    class TopicViewHolder(private val binding: ItemTopicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: MainViewModel, model: TopicModel) {
            with(binding) {
                vm = viewModel
                this.model = model
            }
        }
    }

    companion object {
        private val TOPIC_COMPARATOR = object : DiffUtil.ItemCallback<TopicModel>() {
            override fun areItemsTheSame(oldItem: TopicModel, newItem: TopicModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: TopicModel, newItem: TopicModel): Boolean {
                return oldItem == newItem
            }
        }
    }


}