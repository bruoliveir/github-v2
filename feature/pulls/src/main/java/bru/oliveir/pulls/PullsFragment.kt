package bru.oliveir.pulls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import bru.oliveir.common.base.BaseFragment
import bru.oliveir.common.base.BaseViewModel
import bru.oliveir.pulls.databinding.FragmentPullsBinding
import bru.oliveir.pulls.views.PullsAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class PullsFragment : BaseFragment() {

    private val viewModel: PullsViewModel by viewModel()
    private val args: PullsFragmentArgs by navArgs()
    private lateinit var binding: FragmentPullsBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.loadDataWhenActivityStarts(args)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPullsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        binding.rvPulls.adapter = PullsAdapter(viewModel)
    }
}