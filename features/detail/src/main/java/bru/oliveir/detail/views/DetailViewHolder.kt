package bru.oliveir.detail.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.detail.DetailViewModel
import bru.oliveir.detail.databinding.ViewDetailListItemBinding
import bru.oliveir.model.Item

class DetailViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = ViewDetailListItemBinding.bind(parent)

    fun bindTo(item: Item, viewModel: DetailViewModel) {
        binding.item = item
        binding.viewModel = viewModel
    }
}
