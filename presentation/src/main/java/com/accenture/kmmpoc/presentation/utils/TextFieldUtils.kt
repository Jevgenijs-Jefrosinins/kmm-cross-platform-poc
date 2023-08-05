package com.accenture.kmmpoc.presentation.utils

import android.util.Log
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

private const val NULL_RANGE = "null"
private const val ZERO_RANGE = "0;0"
private const val TEXT = "text"
private const val SELECTION = "selection"
private const val COMPOSITION = "composition"

private fun TextRange?.asString(): String {
    return when {
        this == null -> NULL_RANGE
        this == TextRange.Zero -> ZERO_RANGE
        else -> "$start;$end"
    }
}

private fun String.textRange(): TextRange? {
    return when {
        equals(NULL_RANGE) -> null
        equals(ZERO_RANGE) -> TextRange.Zero
        else -> {
            split(";")
                .takeIf {
                    val validRange = it.size == 2
                    if (validRange.not()) {
                        Log.e("KMM_PoC_App","Invalid string for TextRange!")
                    }
                    validRange
                }
                ?.map {
                    try { it.toInt() }
                    catch (e: NumberFormatException) {
                        Log.e("KMM_PoC_App","Invalid index for TextRange!")
                        0
                    }
                }
                ?.let { TextRange(it[0], it[1]) }
        }
    }
}

fun textFieldValueSaver() = run {
    mapSaver(
        save = {
            mapOf(
                TEXT to it.text,
                SELECTION to it.selection.asString(),
                COMPOSITION to it.composition.asString()
            )
        },
        restore = {
            TextFieldValue(
                text = it[TEXT] as String,
                selection = (it[SELECTION] as String).textRange()!!,
                composition = (it[COMPOSITION] as String).textRange()
            )
        }
    )
}
