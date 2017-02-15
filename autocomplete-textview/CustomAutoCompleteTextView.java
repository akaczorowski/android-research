import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class CustomAutoCompleteTextView extends AutoCompleteTextView{

  public CustomAutoCompleteTextView(Context context) {
    this(context, null);
  }

  public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
    super(context, attrs, R.attr.autoCompleteTextViewStyle);
  }

  @Override
  public boolean enoughToFilter() {
	  //suggestion will be visible when user tap
    return true;
  }
}