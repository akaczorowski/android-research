  private fun setupInputTextListeners() {
        inputText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                addList()
            } else false
        }

        inputText.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                addList()
            } else false
        }
    }

    private fun addList(): Boolean {

        val listName = inputText.text.toString().trim { it <= ' ' }
        if (!listName.isEmpty()) {

            viewModel.insert(listName)

            inputText.setText("")
            hideSoftKeyboard()

            return true
        }

        return false

    }

    private fun hideSoftKeyboard() {
        val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(inputText.windowToken, 0)
    }