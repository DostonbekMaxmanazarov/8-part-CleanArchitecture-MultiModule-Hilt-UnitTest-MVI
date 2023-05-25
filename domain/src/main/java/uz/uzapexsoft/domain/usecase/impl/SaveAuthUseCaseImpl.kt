package uz.uzapexsoft.domain.usecase.impl

import uz.uzapexsoft.domain.models.params.SaveRegistrationParam
import uz.uzapexsoft.domain.repository.AuthRepository
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase
import uz.uzapexsoft.domain.utils.isValidationEmail
import uz.uzapexsoft.domain.utils.isValidationPassword
import uz.uzapexsoft.domain.utils.isValidationPhoneNumber

class SaveAuthUseCaseImpl(val authRepository: AuthRepository) : SaveAuthUseCase {
    override fun invoke(param: SaveRegistrationParam): Boolean {
        val oldAuthentication = authRepository.getAuthentication()

        if (oldAuthentication.phoneNumber == param.phoneNumber)
            return true

        if (param.email.isValidationEmail() &&
            param.password.isValidationPassword() &&
            param.phoneNumber.isValidationPhoneNumber() &&
            param.password == param.confirmPassword
        ) {
            return authRepository.saveAuthentication(saveParam = param)
        }

        return false
    }
}