package bru.oliveir.pulls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bru.oliveir.common.BaseViewModel
import bru.oliveir.model.Pull
import bru.oliveir.pulls.domain.GetPullsByRepositoryUseCase
import bru.oliveir.repository.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PullsViewModel(private val getPullsByRepositoryUseCase: GetPullsByRepositoryUseCase) : BaseViewModel() {

    private var _pulls = MediatorLiveData<Resource<List<Pull>>>()
    private var pullsSource: LiveData<Resource<List<Pull>>> = MutableLiveData()
    val pulls: LiveData<Resource<List<Pull>>> = _pulls

    private lateinit var ownerLogin: String
    private lateinit var repoName: String

    fun loadDataWhenActivityStarts(args: PullsFragmentArgs) {
        ownerLogin = args.ownerLogin
        repoName = args.repoName
        getPulls()
    }

    fun userSwipesToRefresh() {
        getPulls(true)
    }

    private fun getPulls(refresh: Boolean = false) {
        viewModelScope.launch(Dispatchers.Main) {
            _pulls.removeSource(pullsSource)
            withContext(Dispatchers.IO) { pullsSource = getPullsByRepositoryUseCase(refresh, ownerLogin, repoName) }
            _pulls.addSource(pullsSource) {
                _pulls.value = it
            }
        }
    }
}