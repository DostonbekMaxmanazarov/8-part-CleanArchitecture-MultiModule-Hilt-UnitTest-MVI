# 6-part-CleanArchitecture-MultiModule-Mvvm-Hilt
> Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm, Hilt(Dependency Injection).

Androidni loyihalarni ishlab chiqishda [Hilt](https://dagger.dev/hilt/) - bu Google tomonidan taqdim etilgan dependency injection (DI) frameworkidir. U DI frameworki Dagger ustiga qurilgan. Hilt Android ilovamizdagi dependencylarni sozlash va boshqarish jarayonini soddalashtiradi.

:white_check_mark: Bu erda Hiltning asosiy tushunchalari va uning qanday ishlashi haqida qisqacha ma'lumot berishga harakat qilaman:

- **```Hilt annotation:```** Hilt Android ilovamizda DI-ni soddalashtirish uchun foydalanishimiz mumkin bo'lgan bir nechta annotationlarni taqdim etadi. Ko'p ishlatiladigan annotationlardan ba'zilari: @HiltAndroidApp, @AndroidEntryPoint, @Inject, @Provides, @Singleton va boshqalar.
- **```Hilt components:```** Componentlar Hiltning asosiy qurilish tushunchalari hisoblanadi. Ular dependencylarning lifecycleni belgilaydi. Hilt @Singleton, @ActivityScoped, @FragmentScoped va boshqalar kabi oldindan belgilangan Componentlarni taqdim etadi, ulardan turli darajadagi (application, activity, fragment va boshqalar) dependencylarni boshqarish uchun foydalanishimiz mumkin.
- **```Hilt Modules:```** Modullar dependencylarni qanday ta'minlashni aniqlash uchun ishlatiladi. Biz proektda @Module annotatsiyasidan foydalanib Hilt modulini yaratishimiz va dependencylarni qanday yaratish va taqdim etish uchun @Provides annotatsiyasidan foydalanib methodlarni belgilashingiz mumkin.
- **```Hilt AndroidEntryPoint:```** @AndroidEntryPoint annotation Android classlarini (masalan, activitylar, fragmentlar, servicelar va boshqalar) dependencylarn kiritish uchun ishlatiladi. @AndroidEntryPoint bilan classga annotation berganimizda, Hilt ushbu class uchun dependency injectionni boshqarish uchun kerakli kodni yaratadi.
- **```Hilt Application:```** Application classimizga @HiltAndroidApp bilan annotation berishimiz mumkin. Ushbu annotation zarur Hilt componentlarini yaratishni boshlaydi va butun ilovamiz uchun dependency injection infratuzilmasini o'rnatadi.

:white_check_mark: Hilt Android proektlaridagi dependencylarni boshqarishni sezilarli darajada soddalashtiradi. Hiltning avfzalligi, multimodulda foydalanish, testdan o'tkazish va kod yozishni osonlashtiradi.

:white_check_mark: Hilt-dan foydalanish haqida batafsil ma'lumot olish uchun Google tomonidan taqdim etilgan rasmiy [Hilt](https://dagger.dev/hilt/) hujjatlaridan to'liq o'rganishimiz mumkin.

:white_check_mark: Dagger 2 va Hilt ikkalasi ham Android uchun dependency injection (DI) frameworkidir, ammo Hilt Dagger 2 ustiga qurilgan va Android ilovalarida DIni soddalashtirish uchun qo'shimcha abstraktsiyalar va xususiyatlarni taqdim etadi. Dagger 2 va Hilt o'rtasidagi ba'zi asosiy farqlar mavjud:

- **```Boilerplate reduction:```** Hilt asosiy maqsadlaridan biri Android ilovasida DI sozlash uchun zarur boilerplate kod miqdorini kamaytirish hisoblanadi. Hilt bunga under the hood kerakli Dagger kodini yaratish orqali erishadi, shuning uchun biz qo'lda sozlash kodini yozishimiz shart emas.
- **```Simplicity and ease of use:```** Hilt Android proektlari uchun maxsus moslashtirilgan annotationlar to‘plamini taqdim etadi, bu esa uni Dagger 2 bilan solishtirganda yanada intuitiv va foydalanishni osonlashtiradi. @AndroidEntryPoint va @InstallIn kabi Hilt annotationlari dependencylarni sozlash va e’lon qilishni soddalashtiradi.
- **```Integration with Android components:```** Hilt activitylar, fragmentlar, servicelar va ViewModels kabi Android-ga xos componentlar bilan integratsiyani ta'minlaydi. Hiltning @AndroidEntryPoint annotatsiyasi qo'shimcha kod yozmasdan ushbu componentlarni avtomatik kiritish uchun belgilash imkonini beradi. Boshqa tomondan, Dagger 2 bir xil darajadagi integratsiyaga erishish uchun ko'proq qo'lda konfiguratsiyani talab qiladi.
- **```Predefined components and scopes:```** Hilt Android ilovalarida tez-tez ishlatiladigan oldindan belgilangan componentlar va scopelarni taqdim etadi. Misol uchun, @Singleton va @ActivityScoped - bu dependencylarning lifecycleni boshqarish uchun foydalanishimiz mumkin bo'lgan oldindan belgilangan scopelardir. Ushbu oldindan belgilangan scopelar ob'ektlarning ishlash muddatini aniqlashga yordam beradi va ularning to'g'ri yaratilishi va qayta ishlatilishini ta'minlaydi.
- **```Testing support: ```** Hilt bizga dependencylarni osongina almashtirish yoki mock dependencylarni testdan o'tkazishni osonlashtiradi.
- **```Gradual adoption:```** Biz mavjud Dagger 2 proektni bosqichma-bosqich Hilt-ga ko'chirishimiz mumkin, bu esa Hiltning mavjud Dagger 2 componentlari va modullari bilan foydalanish imkonini beradi.

:white_check_mark: Umuman olganda, Hilt Dagger 2 kuchiga asoslanadi va shu bilan birga Android rivojlanishi uchun maxsus moslashtirilgan yuqori darajadagi abstractionni ta'minlaydi. U DI o'rnatish jarayonini soddalashtiradi, boilerplate kodni kamaytiradi, Android componentlari bilan yaxshi integratsiya qiladi va test uchun qo'shimcha funktsiyalarni taklif qiladi. Agar biz yangi Android loyihasini boshlayotgan bo'lsak yoki mavjud Dagger 2 loyihasini ko'chirishni o'ylayotgan bo'lsak, Hilt dependency injection uchun qulay tanlov bo'lishi mumkin.
