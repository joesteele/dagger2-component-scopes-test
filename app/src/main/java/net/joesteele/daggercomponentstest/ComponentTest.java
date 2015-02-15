package net.joesteele.daggercomponentstest;

import android.app.Application;
import android.content.Context;

/**
 * Created by joesteele on 2/15/15.
 */
public class ComponentTest extends Application {
  private AppComponent component;

  @Override public void onCreate() {
    component = Dagger_AppComponent.Initializer.buildAndInject(this);
  }

  public static AppComponent component(Context context) {
    return app(context).component;
  }

  public static ComponentTest app(Context context) {
    return (ComponentTest) context.getApplicationContext();
  }
}
