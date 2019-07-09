package bru.oliveir.master

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bru.oliveir.master.domain.GetAllItemsUseCase
import bru.oliveir.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MasterViewModel(private val getAllItemsUseCase: GetAllItemsUseCase) : ViewModel() {

    private var _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        getAllItems()
    }

    fun userClicksOnItem(item: Item) {
        println("userClicksOnItem ${item.id}")
    }

    private fun getAllItems() {
        viewModelScope.launch(Dispatchers.Main) {
            _items.value = withContext(Dispatchers.IO) { getAllItemsUseCase() }
        }
    }
}