package uz.uzapexsoft.domain.usecase.impl

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import uz.uzapexsoft.domain.models.Authentication
import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.repository.AuthRepository

class GetAuthUseCaseTest {

    private val authRepository = mock<AuthRepository>()

    @AfterEach
    fun resetRepository() {
        Mockito.reset(authRepository)
    }

    @Test
    fun `if phoneNumber and password was already saved successful()`() {
        val testAuthentication = Authentication(password = "123456A+", phoneNumber = "+998 99 000 00 00")
        Mockito.`when`(authRepository.getAuthentication()).thenReturn(testAuthentication)

        val useCase = GetAuthUseCaseImpl(authRepository)
        val testLoginParam = LoginParam(password = "123456A+", phoneNumber = "+998 99 000 00 00")
        val actual = useCase.invoke(testLoginParam)

        val expected = true
        Assertions.assertEquals(expected, actual)
    }
}