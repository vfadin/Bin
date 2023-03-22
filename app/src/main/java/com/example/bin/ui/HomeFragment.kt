package com.example.bin.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bin.R
import com.example.bin.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}