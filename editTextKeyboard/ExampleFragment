package akaczorowski.pl.android.research;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ExampleFragment extends Fragment {

  private static final int MAX_COUNT_VALUE = 50;
  @Bind(R.id.countEditText)
  protected EditText countEditText;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_connection, container, false);
    ButterKnife.bind(this, rootView);

    countEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean isInValid = false;
        if (event == null || event.getAction() == KeyEvent.ACTION_UP) {
          final String text = v.getText().toString();
          int i = Integer.valueOf(text);
          isInValid = isCountValueExceeded(i);
          if (isInValid) {
            //todo
          } else {
            //todo
          }
        }
        return isInValid;
      }
    });
    return rootView;
  }

  @Nullable
  private boolean isCountValueExceeded(int value) {
    boolean result = false;
    if (value > MAX_COUNT_VALUE) {
      result = true;
    }
    return result;
  }
}
