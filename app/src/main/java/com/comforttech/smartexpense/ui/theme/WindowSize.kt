package com.comforttech.smartexpense.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

enum class WindowSize {

    Compact,
    Medium,
    Expanded
}

@Composable
fun rememberWindowSize(): WindowSize {

    val width = LocalConfiguration.current.screenWidthDp

    return when {
        width < 600 -> WindowSize.Compact
        width < 840 -> WindowSize.Medium
        else -> WindowSize.Expanded
    }
}