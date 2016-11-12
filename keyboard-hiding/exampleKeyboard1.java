private void hideSoftKeyboard() {
    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(examplEditText.getWindowToken(), 0);
}