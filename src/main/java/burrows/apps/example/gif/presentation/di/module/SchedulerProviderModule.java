package burrows.apps.example.gif.presentation.di.module;


import burrows.apps.example.gif.presentation.di.scope.PerActivity;
import burrows.apps.example.gif.presentation.SchedulerProvider;
import dagger.Module;
import dagger.Provides;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
@Module
public final class SchedulerProviderModule {
  @Provides @PerActivity SchedulerProvider providerSchedulerProvider() {
    return new SchedulerProvider();
  }
}
