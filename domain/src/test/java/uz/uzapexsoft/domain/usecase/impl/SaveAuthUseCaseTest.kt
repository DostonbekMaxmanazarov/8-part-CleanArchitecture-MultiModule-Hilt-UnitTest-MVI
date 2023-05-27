package uz.uzapexsoft.domain.usecase.impl

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import uz.uzapexsoft.domain.models.Authentication
import uz.uzapexsoft.domain.repository.AuthRepository
import uz.uzapexsoft.domain.models.params.SaveRegistrationParam

class SaveAuthUseCaseTest {

    private val authRepository = mock<AuthRepository>()

    @AfterEach
    fun resetRepository() {
        Mockito.reset(authRepository)
    }

    @Test
    fun `should not save data if phoneNumber was already saved successful()`() {
        val testAuthentication = Authentication(password = "12345A+", phoneNumber = "+998 99 000 00 00")
        Mockito.`when`(authRepository.getAuthentication()).thenReturn(testAuthentication)

        val useCase = SaveAuthUseCaseImpl(authRepository = authRepository)
        val testRegistrationParam = SaveRegistrationParam(phoneNumber = "+998 99 000 00 00")
        val actual = useCase.execute(param = testRegistrationParam)

        val expected = true
        Assertions.assertEquals(expected, actual)
        Mockito.verify(authRepository, Mockito.never()).saveAuthentication(saveParam = any())
    }

    @Test
    fun `should return true if save was successful()`() {
        val testAuthentication = Authentication(password = "12345A+", phoneNumber = "+998 99 000 00 00")
        Mockito.`when`(authRepository.getAuthentication()).thenReturn(testAuthentication)

        val expected = true
        val testRegistrationParam = SaveRegistrationParam(phoneNumber = "+998 99 000 00 01", email = "aaa@aa.uz", password = "12345A++", confirmPassword = "12345A++")
        Mockito.`when`(authRepository.saveAuthentication(saveParam = testRegistrationParam)).thenReturn(expected)

        val useCase = SaveAuthUseCaseImpl(authRepository = authRepository)
        val actual = useCase.execute(param = testRegistrationParam)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(authRepository, Mockito.times(1)).saveAuthentication(saveParam = testRegistrationParam)
    }

    @Test
    fun `should return false if save was successful()`() {
        val testAuthentication = Authentication(password = "12345A+", phoneNumber = "+998 99 000 00 00")
        Mockito.`when`(authRepository.getAuthentication()).thenReturn(testAuthentication)

        val expected = false
        val testRegistrationParam = SaveRegistrationParam(phoneNumber = "+998 99 000 00 01", email = "aaa@aa.uz", password = "12345A++", confirmPassword = "12345A++")
        Mockito.`when`(authRepository.saveAuthentication(saveParam = testRegistrationParam)).thenReturn(expected)

        val useCase = SaveAuthUseCaseImpl(authRepository = authRepository)
        val actual = useCase.execute(param = testRegistrationParam)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(authRepository, Mockito.times(1)).saveAuthentication(saveParam = testRegistrationParam)
    }
}