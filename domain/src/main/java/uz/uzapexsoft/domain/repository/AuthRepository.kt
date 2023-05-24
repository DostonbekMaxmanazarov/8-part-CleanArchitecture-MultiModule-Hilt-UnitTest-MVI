package uz.uzapexsoft.domain.repository

import uz.uzapexsoft.domain.models.params.SaveRegistrationParam
import uz.uzapexsoft.domain.models.Authentication

interface AuthRepository {
    fun saveAuthentication(saveParam: SaveRegistrationParam): Boolean
    fun getAuthentication(): Authentication
}