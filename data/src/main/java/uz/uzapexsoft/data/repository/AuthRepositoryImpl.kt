package uz.uzapexsoft.data.repository

import uz.uzapexsoft.data.mapper.SingleMapper
import uz.uzapexsoft.data.storage.*
import uz.uzapexsoft.data.storage.models.AuthenticationRequest
import uz.uzapexsoft.domain.models.*
import uz.uzapexsoft.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authStorage: AuthStorageSharedPref,
    private val saveAuthParamMapToStorage: SingleMapper<RegistrationParam, AuthenticationRequest>,
    private val authRequestMapToDomain: SingleMapper<AuthenticationRequest, Authentication>
) : AuthRepository {

    override fun saveAuthentication(saveParam: RegistrationParam): Boolean {
        val authentication = saveAuthParamMapToStorage(value = saveParam)
        return authStorage.saveAuthentication(authentication)
    }

    override fun getAuthentication(): Authentication {
        val authentication = authStorage.getAuthentication()
        return authRequestMapToDomain(value = authentication)
    }
}