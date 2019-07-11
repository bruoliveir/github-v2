package bru.oliveir.pulls.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.model.Pull
import bru.oliveir.pulls.PullsViewModel
import bru.oliveir.pulls.databinding.ListItemPullsBinding

class PullsViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = ListItemPullsBinding.bind(parent)

    fun bindTo(pull: Pull, viewModel: PullsViewModel) {
        binding.pull = pull
        binding.viewModel = viewModel
    }
}
