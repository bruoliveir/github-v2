package bru.oliveir.pulls.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.model.Pull
import bru.oliveir.pulls.PullsViewModel
import bru.oliveir.pulls.R

class PullsAdapter(private val viewModel: PullsViewModel) : RecyclerView.Adapter<PullsViewHolder>() {

    private val pulls = mutableListOf<Pull>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PullsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_pulls, parent, false))

    override fun getItemCount() = pulls.size

    override fun onBindViewHolder(holder: PullsViewHolder, position: Int) =
        holder.bindTo(pulls[position], viewModel)

    fun updateData(pulls: List<Pull>) {
        this.pulls.clear()
        this.pulls.addAll(pulls)
        notifyDataSetChanged()
    }
}
