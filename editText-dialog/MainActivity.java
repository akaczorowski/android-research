package akaczorowski.pl.android.research.dialogedittext;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private AlertDialog alertDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    Button btnShowDialog = (Button) findViewById(R.id.btnShowDialog);

    btnShowDialog.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showDialog();
      }
    });

    alertDialog = createDialog();

  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  private void showDialog() {
    alertDialog.show();
  }

  private AlertDialog createDialog() {
    ViewGroup rootView = (ViewGroup) getWindow().getDecorView().findViewById(R.id.activity_main);
    View dialogContentView = getLayoutInflater().inflate(R.layout.dialog_edit_text, rootView,
                                                         false);
    EditText editText = (EditText) dialogContentView.findViewById(R.id.countEditText);
    editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (event == null || event.getAction() == KeyEvent.ACTION_UP) {
         alertDialog.dismiss();
        }
        return false;
      }
    });
    final AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Alert")
                                                            .setView(dialogContentView)
                                                            .create();

    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    return dialog;
  }
}
