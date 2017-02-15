

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

public class CustomScrollLayoutManager extends LinearLayoutManager {

  private static final float CUSTOM_MILLISECONDS_PER_INCH = 40.0f;

  public CustomScrollLayoutManager(Context context) {
    super(context);
  }

  public CustomScrollLayoutManager(Context context, int orientation,
                                   boolean reverseLayout) {
    super(context, orientation, reverseLayout);
  }

  public CustomScrollLayoutManager(Context context, AttributeSet attrs,
                                   int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override
  public void smoothScrollToPosition(RecyclerView recyclerView,
                                     RecyclerView.State state, final int position) {

    LinearSmoothScroller smoothScroller =
        new LinearSmoothScroller(recyclerView.getContext()) {

          //This controls the direction in which smoothScroll looks
          //for your view
          @Override
          public PointF computeScrollVectorForPosition(int targetPosition) {
            return CustomScrollLayoutManager.this
                .computeScrollVectorForPosition(targetPosition);
          }

          //This returns the milliseconds it takes to
          //scroll one pixel.
          @Override
          protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            float t = CUSTOM_MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            return t;
          }

          @Override
          public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd,
                                      int snapPreference) {

            int boxCenterPosition = (boxEnd - boxStart) / 2;
            int viewCenterPosition = (viewEnd - viewStart) / 2;
            int result = (boxStart + boxCenterPosition) - (viewStart + viewCenterPosition);

            return result;
          }
        };

    smoothScroller.setTargetPosition(position);
    startSmoothScroll(smoothScroller);
  }


}