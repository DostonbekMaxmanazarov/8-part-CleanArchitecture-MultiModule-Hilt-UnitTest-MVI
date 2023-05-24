package uz.uzapexsoft.domain.usecase.impl

import org.mockito.kotlin.mock
import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.repository.AuthRepository

class SaveAuthUseCaseImplTest {
    val authRepository = mock<AuthRepository>()

    fun `should not save data if email was already saved`() {
        val useCase = SaveAuthUseCaseImpl(authRepository = authRepository)
        val testParam = RegistrationParam(email = "aaa@bb.uz")
        val actual = useCase.invoke(param = testParam)
    }
}