package com.studiomk.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studiomk.home.viewmodel.HomeViewModel
import com.studiomk.home.databinding.FragmentHomeBinding
import com.studiomk.home.viewmodel.HomeState
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleState() {
        homeViewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is HomeState.HomeInitialState -> handleInitialState(it)
            }
        }
    }

    private fun handleInitialState(state: HomeState.HomeInitialState) {
        binding.textHome.text = state.welcomeText
    }
}