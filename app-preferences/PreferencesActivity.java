package akaczorowski.pl.android.research;

import android.app.Activity;
import android.os.Bundle;

import akaczorowski.pl.android.research.PreferencesFragment;

public class PreferencesActivity extends Activity {

  public static final String KEY_SINGLE_MODE = "pref_mode_single";
  public static final String KEY_MULTI_MODE = "pref_mode_multi";
  public static final String KEY_MULTI2_MODE = "pref_mode_multi2";
  public static final String KEY_DEVICE_NAME = "pref_connected_device_name";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getFragmentManager().beginTransaction().replace(android.R.id.content,
                                                    new PreferencesFragment()).commit();
  }
}
