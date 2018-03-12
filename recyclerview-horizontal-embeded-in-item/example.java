// For inner horizontal RecyclerView in horizontal RecyclerView
// (to make inner RecyclerView scroll work)

sizesRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
  @Override
  public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
    int action = e.getAction();
    switch (action) {
      case MotionEvent.ACTION_MOVE:
        rv.getParent().requestDisallowInterceptTouchEvent(true);
        break;
    }
    return false;
  }

  @Override
  public void onTouchEvent(RecyclerView rv, MotionEvent e) {
  }

  @Override
  public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
  }
});