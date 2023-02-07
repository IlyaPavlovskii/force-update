package io.github.ilyapavlovskii.kmm.change.theme.sample

import io.github.ilyapavlovskii.kmm.change.theme.domain.ioc.ChangeThemeDomainComponent
import io.github.ilyapavlovskii.kmm.kmm.change.theme.presentation.ioc.ChangeThemePresentationComponent
import io.github.ilyapavlovskii.kmm.koin.Component
import net.humans.kmm.mvi.sample.domain.ioc.ChangeThemePlatformDomainComponent
import org.koin.core.module.Module

internal object ChangeThemeComponent : Component {
    override val modules: List<Module> = components()
        .flatMap(Component::modules)

    private fun components(): List<Component> = listOf(
        ChangeThemeDomainComponent,
        ChangeThemePlatformDomainComponent,
        ChangeThemePresentationComponent,
    )
}