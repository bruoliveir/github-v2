package bru.oliveir.repositories.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.model.Repository
import bru.oliveir.repositories.RepositoriesViewModel
import bru.oliveir.repositories.databinding.ListItemRepositoriesBinding

class RepositoriesViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = ListItemRepositoriesBinding.bind(parent)

    fun bindTo(repository: Repository, viewModel: RepositoriesViewModel) {
        binding.repository = repository
        binding.viewModel = viewModel
    }
}
