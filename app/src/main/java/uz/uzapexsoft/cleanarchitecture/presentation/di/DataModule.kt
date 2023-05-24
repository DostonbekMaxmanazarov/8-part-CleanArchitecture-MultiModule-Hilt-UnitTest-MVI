package uz.uzapexsoft.cleanarchitecture.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.uzapexsoft.data.mapper.SingleMapper
import uz.uzapexsoft.data.mapper.impl.AuthenticationRequestMapToDomain
import uz.uzapexsoft.data.mapper.impl.SaveAuthenticationParamMapToStorage
import uz.uzapexsoft.data.models.AuthenticationRequest
import uz.uzapexsoft.data.repository.AuthRepositoryImpl
import uz.uzapexsoft.data.storage.AuthStorageSharedPref
import uz.uzapexsoft.data.storage.impl.AuthStorageSharedPrefImpl
import uz.uzapexsoft.domain.models.Authentication
import uz.uzapexsoft.domain.models.params.SaveRegistrationParam
import uz.uzapexsoft.domain.repository.AuthRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAuthStorage(@ApplicationContext context: Context): AuthStorageSharedPref =
        AuthStorageSharedPrefImpl(context = context)

    @Provides
    @Singleton
    fun providesSaveAuthParamMapToStorage(): SingleMapper<SaveRegistrationParam, AuthenticationRequest> =
        SaveAuthenticationParamMapToStorage()

    @Provides
    @Singleton
    fun provideAuthRequestMapToDomain(): SingleMapper<AuthenticationRequest, Authentication> =
        AuthenticationRequestMapToDomain()

    @Provides
    @Singleton
    fun provideAuthRepository(
        authStorage: AuthStorageSharedPref,
        authRequestMapToDomain: SingleMapper<AuthenticationRequest, Authentication>,
        saveAuthParamMapToStorage: SingleMapper<SaveRegistrationParam, AuthenticationRequest>
    ): AuthRepository = AuthRepositoryImpl(
        authStorage = authStorage,
        authRequestMapToDomain = authRequestMapToDomain,
        saveAuthParamMapToStorage = saveAuthParamMapToStorage
    )

}
