package bru.oliveir.pulls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import bru.oliveir.common.BaseViewModel
import bru.oliveir.model.Pull
import bru.oliveir.pulls.domain.GetPullsByRepositoryUseCase
import bru.oliveir.repository.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PullsViewModel(private val getPullsByRepositoryUseCase: GetPullsByRepositoryUseCase) : BaseViewModel() {

    private var _pulls = MutableLiveData<Resource<List<Pull>>>()
    val pulls: LiveData<Resource<List<Pull>>> = _pulls

    private lateinit var ownerLogin: String
    private lateinit var repoName: String

    fun loadDataWhenActivityStarts(args: PullsFragmentArgs) {
        ownerLogin = args.ownerLogin
        repoName = args.repoName
        getPulls(true)
    }

    fun userSwipesToRefresh() {
        getPulls(true)
    }

    private fun getPulls(refresh: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            _pulls.postValue(getPullsByRepositoryUseCase(refresh, ownerLogin, repoName))
        }
    }
}