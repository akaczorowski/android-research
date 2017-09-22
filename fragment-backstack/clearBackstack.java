    FragmentManager.BackStackEntry entry = getSupportFragmentManager().getBackStackEntryAt(0);
    getSupportFragmentManager().popBackStack(entry.getId(),
                                             FragmentManager.POP_BACK_STACK_INCLUSIVE);
    getSupportFragmentManager().executePendingTransactions();