            
    private fun notFocusable() {
        editText.isFocusable = false
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(noteTextEditText.windowToken, 0)
    }

// When used on double tap, edit begins in position of user double tap
    private fun focusable() {
        editText.isFocusableInTouchMode = true
        editText.isFocusable = true
        editText.requestFocus()
    }