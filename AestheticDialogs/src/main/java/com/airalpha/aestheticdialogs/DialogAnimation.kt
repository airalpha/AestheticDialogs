package com.airalpha.aestheticdialogs

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.unit.IntOffset

enum class DialogAnimation {
    DEFAULT,
    FADE,
    SLIDE,
    SLIDE_UP,
    SLIDE_DOWN,
    SLIDE_LEFT,
    SLIDE_RIGHT,
    EXPAND,
    EXPAND_UP,
    EXPAND_DOWN,
    EXPAND_LEFT,
    EXPAND_RIGHT,
    SCALE
}

fun DialogAnimation.exitAnim(): ExitTransition {
    return when (this) {
        DialogAnimation.DEFAULT -> fadeOut()
        DialogAnimation.FADE -> fadeOut(targetAlpha = 0.3f)
        DialogAnimation.SLIDE -> slideOut(targetOffset = { IntOffset(it.width, it.height) })
        DialogAnimation.SLIDE_UP -> slideOutVertically(targetOffsetY = { it * 2 })
        DialogAnimation.SLIDE_DOWN -> slideOutVertically(targetOffsetY = { -it * 2 })
        DialogAnimation.SLIDE_LEFT -> slideOutHorizontally(targetOffsetX = { -it * 2 })
        DialogAnimation.SLIDE_RIGHT -> slideOutHorizontally(targetOffsetX = { it * 2 })
        DialogAnimation.EXPAND -> shrinkOut()
        DialogAnimation.EXPAND_UP -> shrinkVertically(targetHeight = { it * 2 })
        DialogAnimation.EXPAND_DOWN -> shrinkVertically(targetHeight = { -it * 2 })
        DialogAnimation.EXPAND_LEFT -> shrinkHorizontally(targetWidth = { -it * 2 })
        DialogAnimation.EXPAND_RIGHT -> shrinkHorizontally(targetWidth = { -it * 2 })
        DialogAnimation.SCALE -> scaleOut()
    }
}

fun DialogAnimation.enterAnim(): EnterTransition {
    return when (this) {
        DialogAnimation.DEFAULT -> fadeIn()
        DialogAnimation.FADE -> fadeIn(initialAlpha = 0.3f)
        DialogAnimation.SLIDE -> slideIn(initialOffset = { IntOffset(it.width, it.height) })
        DialogAnimation.SLIDE_UP -> slideInVertically(initialOffsetY = {it*2})
        DialogAnimation.SLIDE_DOWN -> slideInVertically(initialOffsetY = {-it*2})
        DialogAnimation.SLIDE_LEFT -> slideInHorizontally(initialOffsetX = {-it*2})
        DialogAnimation.SLIDE_RIGHT -> slideInHorizontally(initialOffsetX = {it*2})
        DialogAnimation.EXPAND -> expandIn()
        DialogAnimation.EXPAND_UP -> expandVertically(initialHeight = {it*2})
        DialogAnimation.EXPAND_DOWN -> expandVertically(initialHeight = {-it*2})
        DialogAnimation.EXPAND_LEFT -> expandHorizontally(initialWidth = {-it*2})
        DialogAnimation.EXPAND_RIGHT -> expandHorizontally(initialWidth = {it*2})
        DialogAnimation.SCALE -> scaleIn()
    }
}