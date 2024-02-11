package com.aliduman.todoappudemy.data.models

import androidx.compose.ui.graphics.Color
import com.aliduman.todoappudemy.ui.theme.HighPriorityColor
import com.aliduman.todoappudemy.ui.theme.LowPriorityColor
import com.aliduman.todoappudemy.ui.theme.MediumPriorityColor
import com.aliduman.todoappudemy.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}