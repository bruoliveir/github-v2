package bru.oliveir.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bru.oliveir.common.Event
import bru.oliveir.common.base.BaseViewModel
import bru.oliveir.model.Repository
import bru.oliveir.repositories.domain.GetJavaRepositoriesUseCase
import bru.oliveir.repository.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoriesViewModel(private val getJavaRepositoriesUseCase: GetJavaRepositoriesUseCase) : BaseViewModel() {

    private var _repositories = MediatorLiveData<Resource<List<Repository>>>()
    private var repositorySource: LiveData<Resource<List<Repository>>> = MutableLiveData()
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
        viewModelScope.launch(Dispatchers.Main) {
            _repositories.removeSource(repositorySource)
            withContext(Dispatchers.IO) { repositorySource = getJavaRepositoriesUseCase(refresh) }
            _repositories.addSource(repositorySource) {
                _repositories.value = it
                if (it.status == Resource.Status.ERROR) _snackbarError.value = Event(R.string.repositories_error)
            }
        }
    }
}