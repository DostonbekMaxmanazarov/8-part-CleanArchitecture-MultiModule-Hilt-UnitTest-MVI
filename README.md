# 6-part-CleanArchitecture-MultiModule-Mvvm-Hilt
Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm, Hilt(Dependency Injection).

Androidni loyihalarni ishlab chiqishda [Hilt]{https://dagger.dev/hilt/} - bu Google tomonidan taqdim etilgan dependency injection (DI) frameworkidir. U DI frameworki Dagger ustiga qurilgan. Hilt Android ilovamizdagi dependencylarni sozlash va boshqarish jarayonini soddalashtiradi.

:white_check_mark: Bu erda Hiltning asosiy tushunchalari va uning qanday ishlashi haqida qisqacha ma'lumot berishga harakat qilaman:

- **```Hilt annotation:```** Hilt Android ilovamizda DI-ni soddalashtirish uchun foydalanishimiz mumkin bo'lgan bir nechta annotationlarni taqdim etadi. Ko'p ishlatiladigan annotationlardan ba'zilari: @HiltAndroidApp, @AndroidEntryPoint, @Inject, @Provides, @Singleton va boshqalar.
- **```Hilt components:```** Componentlar Hiltning asosiy qurilish tushunchalari hisoblanadi. Ular dependencylarning lifecycleni belgilaydi. Hilt @Singleton, @ActivityScoped, @FragmentScoped va boshqalar kabi oldindan belgilangan Componentlarni taqdim etadi, ulardan turli darajadagi (application, activity, fragment va boshqalar) dependencylarni boshqarish uchun foydalanishimiz mumkin.
- **```Hilt Modules:```** Modullar dependencylarni qanday ta'minlashni aniqlash uchun ishlatiladi. Biz proektda @Module annotatsiyasidan foydalanib Hilt modulini yaratishimiz va dependencylarni qanday yaratish va taqdim etish uchun @Provides annotatsiyasidan foydalanib methodlarni belgilashingiz mumkin.
- **```Hilt AndroidEntryPoint:```** @AndroidEntryPoint annotation Android classlarini (masalan, activitylar, fragmentlar, servicelar va boshqalar) dependencylarn kiritish uchun ishlatiladi. @AndroidEntryPoint bilan classga annotation berganimizda, Hilt ushbu class uchun dependency injectionni boshqarish uchun kerakli kodni yaratadi.
- **```Hilt Application:```** Application classimizga @HiltAndroidApp bilan annotation berishimiz mumkin. Ushbu annotation zarur Hilt componentlarini yaratishni boshlaydi va butun ilovamiz uchun dependency injection infratuzilmasini o'rnatadi.

:white_check_mark: Hilt Android proektlaridagi dependencylarni boshqarishni sezilarli darajada soddalashtiradi. Hiltning avfzalligi, multimodulda foydalanish, testdan o'tkazish va kod yozishni osonlashtiradi.

:white_check_mark: Hilt-dan foydalanish haqida batafsil ma'lumot olish uchun Google tomonidan taqdim etilgan rasmiy [Hilt]{https://dagger.dev/hilt/} hujjatlaridan to'liq o'rganishimiz mumkin.
