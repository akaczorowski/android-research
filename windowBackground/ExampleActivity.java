package akaczorowski.pl.android.research;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ExampleActivity extends AppCompatActivity{
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //different background color set in layout file
    getWindow().setBackgroundDrawable(null);
    setContentView(R.layout.main);
  }
}