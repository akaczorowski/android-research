TypedValue mTypedValue = new TypedValue();

context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
mBackground = mTypedValue.resourceId;
 
view.setBackgroundResource(mBackground);