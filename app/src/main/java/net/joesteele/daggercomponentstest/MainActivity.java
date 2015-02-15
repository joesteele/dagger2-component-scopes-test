package net.joesteele.daggercomponentstest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.widget.FrameLayout.LayoutParams;
import static android.widget.ImageView.ScaleType.CENTER_INSIDE;

/**
 * Created by joesteele on 2/15/15.
 */
public class MainActivity extends Activity {
  private static final String IMAGE_URL = "http://i.ytimg.com/vi/oK_XtfXPkqw/maxresdefault.jpg";

  @Inject Picasso picasso;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityComponent component = Dagger_ActivityComponent.builder()
        .appComponent(ComponentTest.component(this))
        .build();
    component.inject(this);

    ImageView image = new ImageView(this);
    image.setLayoutParams(new LayoutParams(MATCH_PARENT, MATCH_PARENT));
    image.setScaleType(CENTER_INSIDE);

    picasso.load(IMAGE_URL).into(image);

    setContentView(image);
  }
}
