package bru.oliveir.master.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.master.MasterViewModel
import bru.oliveir.master.databinding.ViewMasterListItemBinding
import bru.oliveir.model.Item

class MasterViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = ViewMasterListItemBinding.bind(parent)

    fun bindTo(item: Item, viewModel: MasterViewModel) {
        binding.item = item
        binding.viewModel = viewModel
    }
}
