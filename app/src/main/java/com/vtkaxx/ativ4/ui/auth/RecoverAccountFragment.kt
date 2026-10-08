package com.vtkaxx.ativ4.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.vtkaxx.ativ4.R
import com.vtkaxx.ativ4.databinding.FragmentRecoverAccountBinding
import com.vtkaxx.ativ4.util.initToolbar
import com.vtkaxx.ativ4.util.showBottomSheet

class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstaceState: Bundle?) {
        super.onViewCreated(view, savedInstaceState)
        initToolbar(binding.toolbar)
        auth = FirebaseAuth.getInstance()
        initListener()
    }

    private fun initListener() {
        binding.buttonEnviar.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        val email = binding.editTextEmail.text.toString().trim()
        if (email.isNotBlank()) {
            binding.progressBar.isVisible = true
            recoverAccountUser(email)
        } else {
            showBottomSheet(message = getString(R.string.email_empty))
        }
    }

    private fun recoverAccountUser(email: String) {
        try {
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    binding.progressBar.isVisible = false
                    if (task.isSuccessful) {
                        showBottomSheet(message = getString(R.string.text_message_recover_account_fragment))
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}