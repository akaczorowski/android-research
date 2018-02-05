package akaczorowski.pl.android.research.brandedstartwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    setTheme(R.style.AppTheme);  //in AndroidManifest.xml put in <application> theme, BrandedAppTheme
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
