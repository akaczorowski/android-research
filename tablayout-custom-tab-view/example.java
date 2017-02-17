RelativeLayout rl = (RelativeLayout) LayoutInflater.from(this).inflate(
        R.layout.custom_tab, tabLayout, false);

TextView textView = (TextView) rl.findViewById(R.id.textView);
TextView iconView = (TextView) rl.findViewById(R.id.iconView);

// get awesome font to get icon in text view
iconView.setTypeface(getAwesomeFont(...));

//get any tab and set custom view
tabLayout.getTabAt(0).setCustomView(rl);