package uz.uzapexsoft.domain.usecase

import uz.uzapexsoft.domain.models.params.SaveRegistrationParam

interface SaveAuthUseCase {
    operator fun invoke(param: SaveRegistrationParam): Boolean
}