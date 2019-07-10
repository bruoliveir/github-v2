package bru.oliveir.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bru.oliveir.common.BaseFragment
import bru.oliveir.common.BaseViewModel
import bru.oliveir.detail.databinding.FragmentDetailBinding
import bru.oliveir.detail.views.DetailAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var binding: FragmentDetailBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        binding.rvDetail.adapter = DetailAdapter(viewModel)
    }
}