package bru.oliveir.repositories.views

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import bru.oliveir.model.Repository
import bru.oliveir.repository.util.Resource
import com.bumptech.glide.Glide

object RepositoriesBinding {
    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, resource: Resource<List<Repository>>?) {
        (recyclerView.adapter as RepositoriesAdapter).run {
            resource?.data?.let { updateData(it) }
        }
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    @BindingAdapter("app:showWhenLoading")
    @JvmStatic
    fun showWhenLoading(swipeRefreshLayout: SwipeRefreshLayout, resource: Resource<List<Repository>>?) {
        swipeRefreshLayout.isRefreshing = resource?.status == Resource.Status.LOADING
    }
}