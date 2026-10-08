package com.vtkaxx.ativ4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.vtkaxx.ativ4.R
import com.vtkaxx.ativ4.databinding.FragmentFormTaskBinding
import com.vtkaxx.ativ4.util.initToolbar
import com.vtkaxx.ativ4.util.showBottomSheet

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
        initListener()
    }

    private fun initListener(){
        binding.buttonSave.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        val description = binding.editTextDescricao.text.toString().trim()
        if (description.isNotBlank()){
            Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
        }else{
            showBottomSheet(message = getString(R.string.description_empty_form_task_fragment))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }
}