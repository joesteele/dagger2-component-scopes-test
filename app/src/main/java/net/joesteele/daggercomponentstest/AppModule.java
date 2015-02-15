package net.joesteele.daggercomponentstest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joesteele on 2/15/15.
 */
@Module
public final class AppModule {
  private final ComponentTest app;

  public AppModule(ComponentTest app) {
    this.app = app;
  }

  @Provides @Singleton ComponentTest provideApplication() {
    return app;
  }
}
