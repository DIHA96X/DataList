package com.idaxmx.myapplication.binding

import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.Guideline
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import com.idaxmx.myapplication.model.User
import com.idaxmx.myapplication.ui.widget.HeightWidget
import com.idaxmx.myapplication.ui.widget.UserList

@BindingAdapter("onUserSelected")
fun onUserSelected(v: UserList, callback: CallbackWithUser?) {
    val adapter = v.adapter as UserList.Adapter
    adapter.onUserSelected = { user ->
        callback?.invoke(user)
    }
}

@BindingAdapter("show")
fun showTextView(v: View, list: List<User>?) {
    v.isVisible = list?.isEmpty() ?: true
}

@BindingAdapter("show")
fun showTextView(v: View, b: Boolean) {
    v.isVisible = b
}

@BindingAdapter("onTextChange")
fun onTextChange(v: EditText, callbackWithText: CallbackWithText?) {
    v.doOnTextChanged { text, _, _, _ ->
        callbackWithText?.invoke(text.toString())
    }
}


@BindingAdapter("onClick")
fun onClick(b: Button, callback: Callback) {
    b.setOnClickListener { callback() }
}

@BindingAdapter("layout_constraintGuide_percent")
fun layout_constraintGuide_percent(guideline: Guideline, height: Float) {
    guideline.setGuidelinePercent(height)

}

@BindingAdapter("userHeight")
fun userHeight(v: HeightWidget, h: Float) {
    v.setHeight(h)
    v.updateHeightTextView(h)
}

@BindingAdapter("maxUserHeight")
fun maxUserHeight(v: HeightWidget, mh: Float) {
    v.maxUserHeight(mh)
}