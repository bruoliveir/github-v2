package bru.oliveir.master

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bru.oliveir.master.domain.GetAllItemsUseCase
import bru.oliveir.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MasterViewModel(private val getAllItemsUseCase: GetAllItemsUseCase) : ViewModel() {

    private var _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        getAllItems()
    }

    fun userClicksOnItem(item: Item) {
        println("userClicksOnItem ${item.id}")
        getAllItems(true)
    }

    private fun getAllItems(refresh: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) { _items.postValue(getAllItemsUseCase(refresh)) }
    }
}