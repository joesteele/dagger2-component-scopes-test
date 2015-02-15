# Dagger 2 Component Scopes Test

[Dagger](http://square.github.io/dagger/) is a super useful tool for dependency
injection in Android.  A neat feature of Dagger was the ability to "plus" your
object graph to create a new scoped object graph.

[Dagger 2](http://google.github.io/dagger/) uses components to provide scoping.
However, Dagger 2's components have pretty strict rules on what you can and
cannot do.

In trying out Dagger 2, I was a little confused as to the proper way of building
these scoped components that referenced bindings provided in parent scopes. This
repo shows a simple, albeit contrived, way of referencing bindings in a parent
scope.

## Parent Scope

Any dependency you want to provide to the child scopes, you need to expose them
via the parent component's interface. Here, I expose the `OkHttpClient` dependency
provided by the `NetworkModule`.

```java
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
  public interface AppComponent {
    ComponentTest app();
    OkHttpClient httpClient();

    void inject(ComponentTest app);
  }
}
```

## Child Scope

In the child component/scope, you depend on the parent component and extend it,
which gives your child component visibility to the dependencies exposed via the
parent interface. See [the discussion in this GitHub
issue](https://github.com/google/dagger/issues/107#issuecomment-71524636) for
more details.

```java
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent extends AppComponent {
    void inject(MainActivity activity);
}
```
