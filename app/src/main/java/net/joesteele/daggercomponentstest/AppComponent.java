package net.joesteele.daggercomponentstest;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
  ComponentTest app();
  OkHttpClient httpClient();

  void inject(ComponentTest app);

  final static class Initializer {
    static AppComponent buildAndInject(ComponentTest app) {
      AppComponent component = Dagger_AppComponent.builder()
          .appModule(new AppModule(app))
          .build();
      component.inject(app);
      return component;
    }
    private Initializer() {}
  }
}
