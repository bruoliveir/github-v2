package bru.oliveir.repositories.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bru.oliveir.model.Repository
import bru.oliveir.repositories.R
import bru.oliveir.repositories.RepositoriesViewModel

class RepositoriesAdapter(private val viewModel: RepositoriesViewModel) : RecyclerView.Adapter<RepositoriesViewHolder>() {

    private val repositories = mutableListOf<Repository>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepositoriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_repositories, parent, false))

    override fun getItemCount() = repositories.size

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) =
        holder.bindTo(repositories[position], viewModel)

    fun updateData(repositories: List<Repository>) {
        this.repositories.clear()
        this.repositories.addAll(repositories)
        notifyDataSetChanged()
    }
}
