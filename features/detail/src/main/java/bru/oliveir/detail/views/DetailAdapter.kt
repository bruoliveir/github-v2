package bru.oliveir.detail.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.detail.DetailViewModel
import bru.oliveir.detail.R
import bru.oliveir.model.Item

class DetailAdapter(private val viewModel: DetailViewModel) : RecyclerView.Adapter<DetailViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_detail_list_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) =
        holder.bindTo(items[position], viewModel)

    fun updateData(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}
