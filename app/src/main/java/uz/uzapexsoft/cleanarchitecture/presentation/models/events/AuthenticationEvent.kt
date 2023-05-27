package uz.uzapexsoft.cleanarchitecture.presentation.models.events

interface AuthenticationEvent

data class RegistrationEvent(
    val email: String,
    val password: String,
    val phoneNumber: String,
    val confirmPassword: String
) : AuthenticationEvent

data class LoginEvent(
    val password: String,
    val phoneNumber: String
) : AuthenticationEvent