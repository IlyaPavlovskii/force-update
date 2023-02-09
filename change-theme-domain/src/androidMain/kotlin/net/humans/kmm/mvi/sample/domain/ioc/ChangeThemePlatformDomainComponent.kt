package net.humans.kmm.mvi.sample.domain.ioc

import io.github.ilyapavlovskii.kmm.change.theme.domain.repository.ThemeRepository
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetThemesUseCase
import io.github.ilyapavlovskii.kmm.koin.Component
import net.humans.kmm.mvi.sample.domain.repository.AndroidComposeThemeRepository
import net.humans.kmm.mvi.sample.domain.usecase.AndroidGetThemesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object ChangeThemePlatformDomainComponent : Component {
    override val modules: List<Module> = listOf(
        repositoryModule(),
        useCaseModule(),
    )

    private fun repositoryModule(): Module = module {
        single<ThemeRepository> {
            AndroidComposeThemeRepository(context = androidContext())
        }
    }

    private fun useCaseModule(): Module = module {
        factory<GetThemesUseCase> {
            AndroidGetThemesUseCase()
        }
    }
}
