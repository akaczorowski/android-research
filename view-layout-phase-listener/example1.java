View decorView = MainActivity.this.getWindow().getDecorView();

ViewTreeObserver vtObserver = decorView.getViewTreeObserver();
vtObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
  @Override
  public void onGlobalLayout() {
    int height = decorView.getHeight();
    int height2 = decorView.getBottom();
    // don't forget to remove the listener when done using removeOnGlobalLayoutListener
  }
});