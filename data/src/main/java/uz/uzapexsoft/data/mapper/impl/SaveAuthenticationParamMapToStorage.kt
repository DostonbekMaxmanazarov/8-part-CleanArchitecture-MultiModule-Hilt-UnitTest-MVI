package uz.uzapexsoft.data.mapper.impl

import uz.uzapexsoft.data.mapper.SingleMapper
import uz.uzapexsoft.data.models.AuthenticationRequest
import uz.uzapexsoft.domain.models.params.SaveRegistrationParam

class SaveAuthenticationParamMapToStorage : SingleMapper<SaveRegistrationParam, AuthenticationRequest> {
    override fun invoke(value: SaveRegistrationParam): AuthenticationRequest {
        return AuthenticationRequest(
            email = value.email,
            password = value.password,
            phoneNumber = value.phoneNumber,
        )
    }
}