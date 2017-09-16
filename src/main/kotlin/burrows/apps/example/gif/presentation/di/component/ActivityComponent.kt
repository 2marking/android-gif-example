package burrows.apps.example.gif.presentation.di.component

import burrows.apps.example.gif.presentation.adapter.GifAdapter
import burrows.apps.example.gif.presentation.di.module.LeakCanaryModule
import burrows.apps.example.gif.presentation.di.module.NetModule
import burrows.apps.example.gif.presentation.di.module.RiffsyModule
import burrows.apps.example.gif.presentation.di.scope.PerActivity
import burrows.apps.example.gif.presentation.main.MainActivity
import dagger.Component

/**
 * @author [Jared Burrows](mailto:jaredsburrows@gmail.com)
 */
@PerActivity
@Component(
  dependencies = arrayOf(AppComponent::class),
  modules = arrayOf(NetModule::class, RiffsyModule::class, LeakCanaryModule::class))
interface ActivityComponent {
  // Injections
  fun inject(mainActivity: MainActivity)
  fun inject(gifAdapter: GifAdapter)

  // Setup components dependencies and modules
  companion object {
    fun init(appComponent: AppComponent): ActivityComponent {
      return DaggerActivityComponent.builder()
        .appComponent(appComponent)
        .build()
    }
  }
}
