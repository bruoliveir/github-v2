package bru.oliveir.master.views

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import bru.oliveir.model.Item
import bru.oliveir.repository.util.Resource
import com.bumptech.glide.Glide

object MasterBinding {
    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, resource: Resource<List<Item>>?) {
        (recyclerView.adapter as MasterAdapter).run {
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
    fun showWhenLoading(swipeRefreshLayout: SwipeRefreshLayout, resource: Resource<List<Item>>?) {
        swipeRefreshLayout.isRefreshing = resource?.status == Resource.Status.LOADING
    }
}