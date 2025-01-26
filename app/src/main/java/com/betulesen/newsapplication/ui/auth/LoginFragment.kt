package com.betulesen.newsapplication.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.betulesen.newsapplication.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginEvents()

    }

    private fun loginEvents(){
        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUp.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToHeadlinesFragment()
            findNavController().navigate(action)
        }

        binding.loginButton.setOnClickListener {
            val email = binding.loginEmailEditText.text.toString().trim()
            val pass = binding.loginPasswordEditText.text.toString().trim()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(context,"Welcome",Toast.LENGTH_SHORT).show()
                        val action = LoginFragmentDirections.actionLoginFragmentToHeadlinesFragment()
                        findNavController().navigate(action)

                    }else{
                        Toast.makeText(context,it.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context,"Empty spaces are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}