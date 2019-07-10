package bru.oliveir.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bru.oliveir.common.BaseViewModel
import bru.oliveir.detail.domain.GetAllItemsUseCase
import bru.oliveir.model.Item
import bru.oliveir.repository.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val getAllItemsUseCase: GetAllItemsUseCase) : BaseViewModel() {

    private var _items = MutableLiveData<Resource<List<Item>>>()
    val items: LiveData<Resource<List<Item>>> = _items

    init {
        getAllItems()
    }

    fun userSwipesToRefresh() {
        getAllItems(true)
    }

    private fun getAllItems(refresh: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) { _items.postValue(getAllItemsUseCase(refresh)) }
    }
}