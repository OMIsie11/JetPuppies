package io.github.omisie11.jetpuppies.ui.screens.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.omisie11.jetpuppies.R

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    object HomeScreen : BottomNavigationScreens(
        "home",
        R.string.bottom_bar_item_home,
        Icons.Outlined.Home
    )

    object LikedScreen : BottomNavigationScreens(
        "liked",
        R.string.bottom_bar_item_liked,
        Icons.Outlined.FavoriteBorder
    )

    object SettingsScreen : BottomNavigationScreens(
        "settings",
        R.string.bottom_bar_item_settings,
        Icons.Outlined.Settings
    )
}
