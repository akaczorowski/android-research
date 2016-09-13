package akaczorowski.pl.android.research;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import akaczorowski.pl.android.research.R;
import akaczorowski.pl.android.research.PreferencesActivity;

import java.util.HashSet;

public class PreferencesFragment extends PreferenceFragment
    implements SharedPreferences.OnSharedPreferenceChangeListener {

  private CheckBoxPreference[] modePrefs;
  private HashSet<String> modePrefsKeys = new HashSet<>();

  private CheckBoxPreference[] findDeviceModePrefs(PreferenceScreen preferences,
                                                  String... keys) {
    modePrefsKeys.clear();
    CheckBoxPreference[] prefs = new CheckBoxPreference[keys.length];
    for (int i = 0; i < keys.length; i++) {
      prefs[i] = (CheckBoxPreference) preferences.findPreference(keys[i]);
      modePrefsKeys.add(keys[i]);
    }
    return prefs;
  }

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    addPreferencesFromResource(R.xml.preferences);

    PreferenceScreen preferences = getPreferenceScreen();
    modePrefs = findDeviceModePrefs(preferences,
                                        PreferencesActivity.KEY_SINGLE_MODE,
                                        PreferencesActivity.KEY_MULTI_MODE,
                                        PreferencesActivity.KEY_MULTI2_MODE);
    setupModePrefsView(modePrefs);

    Preference changeDevice = findPreference("pref_change_device");
    changeDevice.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
      @Override
      public boolean onPreferenceClick(Preference preference) {
        //todo

        return true;
      }
    });
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override
  public void onResume() {
    super.onResume();
    final String deviceNameText = PreferenceManager.getDefaultSharedPreferences(
        getActivity().getApplicationContext()).getString(
        PreferencesActivity.KEY_DEVICE_NAME, "NONE");
    EditTextPreference pefDeviceName = (EditTextPreference) findPreference(
        "pref_connected_device_name");
    pefDeviceName.setSummary(deviceNameText);
  }

  private void setupModePrefsView(CheckBoxPreference[] checkBoxPrefs) {
    boolean isCheckedPrefSetup = false;
    for (CheckBoxPreference pref : checkBoxPrefs) {
      if (pref.isChecked() && !isCheckedPrefSetup) {
        pref.setEnabled(false);
        isCheckedPrefSetup = true;
      } else {
        pref.setChecked(false);
        pref.setEnabled(true);
      }
    }
  }

  private void disableOtherModePrefs(String key) {
    for (CheckBoxPreference pref : modePrefs) {
      if (!pref.getKey().equals(key)) {
        pref.setChecked(false);
        pref.setEnabled(true);
      } else {
        pref.setEnabled(false);
      }
    }
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    if (modePrefsKeys.contains(key)) {
      boolean isChecked = sharedPreferences.getBoolean(key, false);
      if (isChecked) {
        disableOtherModePrefs(key);
      }
    }
  }

  @Override
  public void onStart() {
    super.onStart();
    getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

  }

  @Override
  public void onStop() {
    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    super.onStop();
  }
}
