public SimpleStringRecyclerViewAdapter(Context context, List<String> items) {
    context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
    mBackground = mTypedValue.resourceId;
    mValues = items;
}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item, parent, false);
    view.setBackgroundResource(mBackground);
    return new ViewHolder(view);
}