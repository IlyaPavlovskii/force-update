package io.github.ilyapavlovskii.kmm.change.theme.presentation.ioc

import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.State
import io.github.ilyapavlovskii.kmm.change.theme.presentation.ChangeThemeViewModel
import io.github.ilyapavlovskii.kmm.change.theme.presentation.ChangeThemeViewState
import io.github.ilyapavlovskii.kmm.change.theme.presentation.ChangeThemeViewStateConverter
import io.github.ilyapavlovskii.kmm.koin.Component
import net.humans.kmm.mvi.ViewStateConverter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ChangeThemePresentationComponent : Component {
    override val modules: List<Module> = listOf(
        presentationModule(),
        viewModelModule(),
    )

    private fun presentationModule(): Module = module {
        factory<ViewStateConverter<State, ChangeThemeViewState>>(named<ChangeThemeRedux>()) {
            ChangeThemeViewStateConverter()
        }
    }

    private fun viewModelModule(): Module = module {
        viewModel {
            ChangeThemeViewModel(
                reducer = get(named<ChangeThemeRedux>()),
                effectHandler = get(named<ChangeThemeRedux>()),
                viewStateConverter = get(named<ChangeThemeRedux>()),
            )
        }
    }
}
