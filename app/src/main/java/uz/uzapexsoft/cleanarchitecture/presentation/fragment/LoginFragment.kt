package uz.uzapexsoft.cleanarchitecture.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.uzapexsoft.cleanarchitecture.R
import uz.uzapexsoft.cleanarchitecture.databinding.FragmentLoginBinding
import uz.uzapexsoft.cleanarchitecture.presentation.models.events.LoginEvent
import uz.uzapexsoft.cleanarchitecture.presentation.vm.LoginViewModel
import kotlin.math.log

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val vm: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentLoginBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        initClickView()
        observeData()
    }

    private fun initClickView() = binding.apply {
        btnLogin.setOnClickListener {
            val password = etPassword.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val loginEvent = LoginEvent(password = password, phoneNumber = phoneNumber)
            vm.send(event = loginEvent)
        }
    }

    private fun observeData() {
        vm.resultLiveData.observe(viewLifecycleOwner) { state ->
            binding.tvSuccess.text = state.result.toString()
            if (state.result) Toast.makeText(requireContext(), R.string.success, Toast.LENGTH_SHORT).show()
            else Toast.makeText(requireContext(), R.string.failed, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
