package com.example.bin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bin.domain.RequestResult
import com.example.bin.domain.entity.BankCard
import com.example.bin.domain.repo.IHomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: IHomeRepo,
) : ViewModel() {

    private val _bankCardStateFlow = MutableStateFlow<BankCard?>(null)
    val bankCardStateFlow = _bankCardStateFlow.asStateFlow()

    fun getCardInfo(bin: String) {
        viewModelScope.launch {
            when (val response = repo.getCardInfo(bin)) {
                is RequestResult.Success -> {
                    _bankCardStateFlow.value = response.result
                }
                is RequestResult.Error -> {}
            }
        }
    }
}