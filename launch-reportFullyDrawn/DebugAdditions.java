package akaczorowski.pl.android.research;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;

public final class DebugAdditions {

  private static final Impl IMPL;

  static {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      IMPL = new LollipopImpl();
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      IMPL = new KitKatImpl();
    } else {
      IMPL = BaseImpl();
    }
  }

  private DebugAdditions() {
    // No instances
  }

  public static void reportFullyDrawn(Activity activity) {
    IMPL.reportFullyDrawn(activity);
  }

  private interface Impl {
    void reportFullyDrawn(Activity activity);
  }

  private static final class BaseImpl implements Impl {
    @Override
    public void reportFullyDrawn(Activity activity) {
      // No-op
    }
  }

  private static final class KitKatImpl implements Impl {
    @Override
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void reportFullyDrawn(Activity activity) {
      try {
        activity.reportFullyDrawn();
      } catch (SecurityException e) {
      }
    }
  }

  private static final class LollipopImpl implements Impl {
    @Override
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void reportFullyDrawn(Activity activity) {
      activity.reportFullyDrawn();
    }
  }

}
