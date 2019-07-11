package bru.oliveir.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bru.oliveir.common.BaseFragment
import bru.oliveir.common.BaseViewModel
import bru.oliveir.repositories.databinding.FragmentRepositoriesBinding
import bru.oliveir.repositories.views.RepositoriesAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoriesFragment : BaseFragment() {

    private val viewModel: RepositoriesViewModel by viewModel()
    private lateinit var binding: FragmentRepositoriesBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        binding.rvRepositories.adapter = RepositoriesAdapter(viewModel)
    }
}