package burrows.apps.example.gif.presentation.di.module

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import dagger.Module
import dagger.Provides

/**
 * @author [Jared Burrows](mailto:jaredsburrows@gmail.com)
 */
@Module
class LeakCanaryModule {
  @Provides fun providesRefWatcher(application: Application): RefWatcher = LeakCanary.install(application)
}
