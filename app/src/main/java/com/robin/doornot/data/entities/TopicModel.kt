package com.robin.doornot.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopicModel(
    val topic: String,
    val positiveAnswer: String,
    val negativeAnswer: String
) : Parcelable