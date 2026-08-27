package com.vtkaxx.Ativ4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.vtkaxx.Ativ4.R
import com.vtkaxx.Ativ4.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {

    private var _biding: FragmentTodoBinding? = null
    private val binding get() = _biding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners(){
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate((R.id.action_homeFragment_to_formTaskFragment))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }

}