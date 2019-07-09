package bru.oliveir.master.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.master.MasterViewModel
import bru.oliveir.master.R
import bru.oliveir.model.Item

class MasterAdapter(private val viewModel: MasterViewModel) : RecyclerView.Adapter<MasterViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MasterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_master_list_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) =
        holder.bindTo(items[position], viewModel)

    fun updateData(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}
