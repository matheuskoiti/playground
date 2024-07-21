package com.studiomk.dashboard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.studiomk.dashboard.adapter.MovieAdapter
import com.studiomk.dashboard.viewmodel.DashboardViewModel
import com.studiomk.dashboard.databinding.FragmentDashboardBinding
import com.studiomk.dashboard.viewmodel.DashboardState
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val dashboardViewModel: DashboardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleState()
        setupListeners()
    }

    private fun setupListeners() {
        binding.errorButton.setOnClickListener {
            dashboardViewModel.fetchList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleState() {
        dashboardViewModel.state.observe(viewLifecycleOwner) { state ->
            when(state) {
                is DashboardState.DashBoardListState -> handleListState(state)
                is DashboardState.DashBoardLoadingState -> handleLoadingState()
                is DashboardState.DashBoardErrorState -> handleErrorState(state)
            }
        }
    }

    private fun handleLoadingState() {
        with(binding) {
            progressBar.visibility = View.VISIBLE
            dashboardList.visibility = View.GONE
            errorLayout.visibility = View.GONE
        }
    }

    private fun handleListState(state: DashboardState.DashBoardListState) {
        with(binding) {
            dashboardList.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            errorLayout.visibility = View.GONE
            dashboardList.layoutManager = LinearLayoutManager(activity)
            dashboardList.adapter = MovieAdapter(state.list)
        }
    }

    private fun handleErrorState(state: DashboardState.DashBoardErrorState) {
        with(binding) {
            errorLayout.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            dashboardList.visibility = View.GONE
            errorMessage.text = "An error occurred: ${state.errorMessage}"
        }
    }
}