package akaczorowski.pl.android.research;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class LastPositionEditText extends EditText {

  public LastPositionEditText(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

  }

  public LastPositionEditText(Context context, AttributeSet attrs) {
    super(context, attrs);

  }

  public LastPositionEditText(Context context) {
    super(context);

  }

  @Override
  public void onSelectionChanged(int start, int end) {
    CharSequence text = getText();
    if (text != null) {
      if (start != text.length() || end != text.length()) {
        setSelection(text.length(), text.length());
        return;
      }
    }
    super.onSelectionChanged(start, end);
  }

}
