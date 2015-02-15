package net.joesteele.daggercomponentstest;

import dagger.Component;

/**
 * Created by joesteele on 2/15/15.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent extends AppComponent {
  void inject(MainActivity activity);
}
