package akaczorowski.pl.android.research.placeholderui2;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    ThemeUtils.ensureRuntimeTheme(this);
    //SystemClock.sleep(2000l);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }
}
