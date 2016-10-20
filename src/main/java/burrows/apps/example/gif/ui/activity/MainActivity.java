package burrows.apps.example.gif.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import burrows.apps.example.gif.R;
import burrows.apps.example.gif.ui.fragment.MainFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Main activity that will load our Fragments via the Support Fragment Manager.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public final class MainActivity extends AppCompatActivity {
  @BindView(R.id.tool_bar) Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    // Bind views
    ButterKnife.bind(this);

    // Setup Toolbar
    toolbar.setNavigationIcon(R.mipmap.ic_launcher);
    toolbar.setTitle(R.string.main_screen_title);
    setSupportActionBar(toolbar);

    // Use Fragments
    if (savedInstanceState == null) {
      getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.content_frame, new MainFragment(), MainFragment.class.getSimpleName())
        .commit();
    }
  }
}
