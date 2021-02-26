package io.github.omisie11.jetpuppies.ui.screens.main

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainScreen() {

    Scaffold(
        bottomBar = {
            BottomBar(
                items = listOf(
                    BottomNavigationScreens.HomeScreen,
                    BottomNavigationScreens.LikedScreen,
                    BottomNavigationScreens.SettingsScreen,
                )
            )
        }
    ) {

    }
}

@Composable
fun BottomBar(
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null,
                    )
                },
                selected = screen.route == "home",
                label = {
                    Text(
                        text = stringResource(screen.title)
                    )
                },
                alwaysShowLabel = false,
                onClick = {
                    Log.d("BottomBar", "Item clicked: ${screen.title}")
                })
        }
    }
}