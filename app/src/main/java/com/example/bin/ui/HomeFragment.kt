package com.example.bin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bin.R
import com.example.bin.databinding.FragmentHomeBinding
import com.example.bin.domain.entity.historyDataStore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val historyAdapter = HistoryRecyclerViewAdapter()
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                requireContext().historyDataStore.data.collect {
                    if (it.list.isNotEmpty())
                        binding.textViewHistoryTitle.visibility = View.VISIBLE
                    historyAdapter.updateData(it.list)

                }
            }
            viewModel.bankCardStateFlow.collect { card ->
                card?.let {
                    with(binding) {
                        textViewCardInfo.text = card.toString()
                        textViewBankInfo.text = card.bank.toString()
                        textViewBankUrl.text = card.bank.url
                        textViewCountryInfo.text = card.country.toString()
                    }

                }
            }
        }
        bindUi()
    }

    private fun bindUi() {
        with(binding) {
            recyclerViewHistory.apply {
                adapter = historyAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            textInputBin.apply {
                imeOptions = EditorInfo.IME_ACTION_DONE
                setOnEditorActionListener { text, actionId, _ ->
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        val bin = text.text.toString()
                        viewModel.getCardInfo(bin)
                        return@setOnEditorActionListener true
                    }
                    false
                }
                isSingleLine = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}