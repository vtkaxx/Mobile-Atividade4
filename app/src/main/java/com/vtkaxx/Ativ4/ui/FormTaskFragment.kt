package com.vtkaxx.Ativ4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vtkaxx.Ativ4.R
import com.vtkaxx.Ativ4.databinding.FragmentFormTaskBinding
import com.vtkaxx.Ativ4.util.initToolbar

class FormTaskFragment : Fragment() {
    private var _biding: FragmentFormTaskBinding? = null
    private val binding get() = _biding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstaceState: Bundle?) {
        super.onViewCreated(view, savedInstaceState)
        initToolbar(binding.toolbar)
    }
}