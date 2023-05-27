package uz.uzapexsoft.cleanarchitecture.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.uzapexsoft.cleanarchitecture.presentation.models.events.AuthenticationEvent
import uz.uzapexsoft.cleanarchitecture.presentation.models.events.RegistrationEvent
import uz.uzapexsoft.cleanarchitecture.presentation.models.states.RegistrationState
import uz.uzapexsoft.domain.models.params.SaveRegistrationParam
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val saveAuthUseCase: SaveAuthUseCase
) : ViewModel() {

    private var saveMutableLiveData = MutableLiveData<RegistrationState>()
    val stateLiveData: LiveData<RegistrationState> get() = saveMutableLiveData

    fun send(event: AuthenticationEvent) {
        when (event) {
            is RegistrationEvent -> registration(
                email = event.email,
                password = event.password,
                phoneNumber = event.phoneNumber,
                confirmPassword = event.confirmPassword
            )
        }
    }

    private fun registration(email: String, password: String, phoneNumber: String, confirmPassword: String) {
        val registrationParams = SaveRegistrationParam(
            email = email,
            password = password,
            phoneNumber = phoneNumber,
            confirmPassword = confirmPassword)
        val result = saveAuthUseCase(param = registrationParams)
        saveMutableLiveData.value = RegistrationState(saveResult = result)
    }
}