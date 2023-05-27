package uz.uzapexsoft.cleanarchitecture.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.uzapexsoft.cleanarchitecture.presentation.models.events.AuthenticationEvent
import uz.uzapexsoft.cleanarchitecture.presentation.models.events.LoginEvent
import uz.uzapexsoft.cleanarchitecture.presentation.models.events.RegistrationEvent
import uz.uzapexsoft.cleanarchitecture.presentation.models.states.LoginState
import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.usecase.GetAuthUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getAuthUseCase: GetAuthUseCase
) : ViewModel() {

    private var stateMutableLiveData = MutableLiveData<LoginState>()
    val resultLiveData: LiveData<LoginState> get() = stateMutableLiveData

    fun send(event: AuthenticationEvent) {
        when (event) {
            is LoginEvent -> login(
                password = event.password,
                phoneNumber = event.phoneNumber
            )
        }
    }

    private fun login(phoneNumber: String, password: String) {
        val loginParam = LoginParam(phoneNumber = phoneNumber, password = password)
        val result = getAuthUseCase(param = loginParam)
        stateMutableLiveData.value = LoginState(result = result)
    }
}