package uz.abbosbek.multithread.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.abbosbek.multithread.database.entity.NewsEntity
import uz.abbosbek.multithread.databinding.ItemNewsBinding

class NewsAdapter:ListAdapter<NewsEntity, NewsAdapter.Vh>(MyDiffUtils()) {

    inner class Vh(val itemNewsBinding: ItemNewsBinding):RecyclerView.ViewHolder(itemNewsBinding.root){

        fun onBind(newItem: NewsEntity){
            itemNewsBinding.apply {
                tv1.text = newItem.title
                tv2.text = newItem.description
            }
        }
    }

    class MyDiffUtils:DiffUtil.ItemCallback<NewsEntity>(){
        override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}