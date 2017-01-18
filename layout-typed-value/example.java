int padding = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                							 4, 
                							 getActivity().getResources().getDisplayMetrics()
                							 );

text.setPadding(padding, padding, padding, padding);