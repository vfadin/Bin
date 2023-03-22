package com.example.bin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bin.databinding.FragmentBinBinding

class BinFragment : Fragment(R.layout.fragment_bin) {

    private var _binding: FragmentBinBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}