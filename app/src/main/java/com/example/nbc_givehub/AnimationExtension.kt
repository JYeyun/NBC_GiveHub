package com.example.nbc_givehub

import android.app.Activity

fun Activity.slideLeft() {
    overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
}

fun Activity.slideRight() {
    overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
}

fun Activity.slideUp() {
    overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit)
}

fun Activity.slideDown() {
    overridePendingTransition(R.anim.slide_down_enter, R.anim.slide_down_exit)
}