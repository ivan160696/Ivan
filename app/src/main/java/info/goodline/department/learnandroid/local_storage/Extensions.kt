package info.goodline.department.learnandroid.local_storage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start