package com.example.acronymsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.acronymsapp.R
import com.example.acronymsapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var adapter: AcronymAdapter
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        binding.viewModel = viewModel

        initRecyclerView()
        observeData()
    }

    private fun observeData() {
        viewModel.data.observe(viewLifecycleOwner) {acronymResponse ->
            acronymResponse?.let {
                val fullForm = acronymResponse[0].lfd
                adapter.updateList(fullForm)
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            if(errorMessage.isNullOrEmpty()) {
                binding.errorMessageTV.visibility = View.GONE
            }else {
                binding.errorMessageTV.text = errorMessage
                binding.errorMessageTV.visibility = View.VISIBLE
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.progressBar.visibility = View.VISIBLE
            }else {
                binding.progressBar.visibility = View.GONE
            }
        }

    }

    private fun initRecyclerView() {
        adapter = AcronymAdapter()
        binding.recyclerViewAcronyms.adapter = adapter
    }

}