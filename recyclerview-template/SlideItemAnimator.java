package akaczorowski.pl.android.research;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.animation.DecelerateInterpolator;


public class SlideItemAnimator extends DefaultItemAnimator {

  @Override
  public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
    runEnterAnimation((PersonsAdapter.PersonViewHolder) viewHolder);
    return false;
  }

  private void runEnterAnimation(
      final PersonsAdapter.PersonViewHolder holder) {
    final int screenHeight = Utils.getScreenHeight(holder.itemView.getContext());
    holder.itemView.setTranslationY(screenHeight);
    holder.itemView.animate()
                   .translationY(0)
                   .setInterpolator(new DecelerateInterpolator(3.f))
                   .setDuration(700)
                   .setListener(new AnimatorListenerAdapter() {
                     @Override
                     public void onAnimationEnd(Animator animation) {
                       dispatchAddFinished(holder);
                     }
                   })
                   .start();
  }
}