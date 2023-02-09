package io.github.ilyapavlovskii.kmm.change.theme.domain.ioc

import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeEffectHandler
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeReducer
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.Effect
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.Message
import io.github.ilyapavlovskii.kmm.change.theme.domain.ChangeThemeRedux.State
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetSelectedThemeUseCase
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.GetThemeStateUseCase
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.SetThemeUseCase
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.impl.DefaultGetSelectedThemeUseCase
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.impl.DefaultGetThemeStateUseCase
import io.github.ilyapavlovskii.kmm.change.theme.domain.usecase.impl.DefaultSetThemeUseCase
import io.github.ilyapavlovskii.kmm.koin.Component
import net.humans.kmm.mvi.ComplexReducer
import net.humans.kmm.mvi.CoroutineEffectHandler
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ChangeThemeDomainComponent : Component {
    override val modules: List<Module> = listOf(
        mviModule(),
        useCaseModule(),
    )

    private fun mviModule(): Module = module {
        factory<ComplexReducer<State, Message, Effect>>(named<ChangeThemeRedux>()) {
            ChangeThemeReducer()
        }
        factory<CoroutineEffectHandler<Effect, Message>>(named<ChangeThemeRedux>()) {
            ChangeThemeEffectHandler(
                getThemesUseCase = get(),
                getSelectedThemeUseCase = get(),
                setThemeUseCase = get(),
            )
        }
    }

    private fun useCaseModule(): Module = module {
        factory<GetSelectedThemeUseCase> {
            DefaultGetSelectedThemeUseCase(repository = get())
        }
        factory<SetThemeUseCase> {
            DefaultSetThemeUseCase(repository = get())
        }
        factory<GetThemeStateUseCase> {
            DefaultGetThemeStateUseCase(repository = get())
        }
    }
}
