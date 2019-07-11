package bru.oliveir.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bru.oliveir.common.BaseViewModel
import bru.oliveir.model.Repository
import bru.oliveir.repositories.domain.GetJavaRepositoriesUseCase
import bru.oliveir.repository.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositoriesViewModel(private val getJavaRepositoriesUseCase: GetJavaRepositoriesUseCase) : BaseViewModel() {

    private var _repositories = MutableLiveData<Resource<List<Repository>>>()
    val repositories: LiveData<Resource<List<Repository>>> = _repositories

    init {
        getRepositories()
    }

    fun userClicksOnRepository(repository: Repository) {
        navigate(
            RepositoriesFragmentDirections.actionRepositoriesToPulls(
                repository.name,
                repository.owner!!.login
            )
        )
    }

    fun userSwipesToRefresh() {
        getRepositories(true)
    }

    private fun getRepositories(refresh: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) { _repositories.postValue(getJavaRepositoriesUseCase(refresh)) }
    }
}