package com.evanisnor.greeting

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideSoftKeyboard() {
    this.currentFocus?.let {
        hideSoftKeyboard(it)
    }
}

fun Activity.hideSoftKeyboard(view: View) {
    val imm: InputMethodManager =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}
