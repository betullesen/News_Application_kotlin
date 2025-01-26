package com.betulesen.newsapplication.ui.auth


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.betulesen.newsapplication.R
import com.betulesen.newsapplication.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerEvents()

    }


    private fun registerEvents(){
        firebaseAuth = FirebaseAuth.getInstance()

        binding.haveAccountTextView.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        binding.signUpButton.setOnClickListener {
            val email = binding.SignupEmailEditText.text.toString().trim()
            val pass = binding.SignupPasswordEditText.text.toString().trim()
            val confirmPass = binding.SignupConfirmPasswordEditText.text.toString().trim()

            if(email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if (pass == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            val action = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
                            findNavController().navigate(action)

                        }else{
                            Toast.makeText(context,it.exception?.message,Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(context,"Password does not match",Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(context,"Empty spaces are not allowed",Toast.LENGTH_SHORT).show()
            }
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}