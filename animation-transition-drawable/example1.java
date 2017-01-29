TransitionDrawable transitionDrawable = (TransitionDrawable) transitionExampleView.getBackground();
// using crossfade, no overdraw is introduced
transitionDrawable.setCrossFadeEnabled(true);
transitionDrawable.startTransition(500);

// no crossfade, second drawable is drawn over first - overdraw is introduced
TransitionDrawable transitionDrawable2 = (TransitionDrawable) transitionExampleView2.getBackground();
transitionDrawable2.startTransition(500);