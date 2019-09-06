package com.example.test_mvvm_git.view.adapter

import android.view.View
import androidx.databinding.BindingAdapter

class CustomBindingAdapter {
    companion object {
        @BindingAdapter("visibleGone")
        fun showHide(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}