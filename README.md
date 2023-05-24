# 7-part-CleanArchitecture-MultiModule-Mvvm-Hilt-UnitTest
> Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm, Hilt(Dependency Injection), UnitTest(JUnit5).

Domain module uchun UnitTest yozdim, bunda usecase classlar testdan o'tkazildi.

```kotlin
@Test
    fun `should not save data if phoneNumber was already saved successful()`() {
        val testAuthentication = Authentication(password = "12345A+", phoneNumber = "+998 99 032 44 98")
        Mockito.`when`(authRepository.getAuthentication()).thenReturn(testAuthentication)

        val useCase = SaveAuthUseCaseImpl(authRepository = authRepository)
        val testRegistrationParam = SaveRegistrationParam(phoneNumber = "+998 99 032 44 98")
        val actual = useCase(param = testRegistrationParam)

        val expected = true
        Assertions.assertEquals(expected, actual)
        Mockito.verify(authRepository, Mockito.never()).saveAuthentication(saveParam = any())
    }
```
