package io.github.omisie11.jetpuppies.ui.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.github.omisie11.jetpuppies.data.lastSeenPuppies
import io.github.omisie11.jetpuppies.data.puppies

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                items = listOf(
                    BottomNavigationScreens.HomeScreen,
                    BottomNavigationScreens.LikedScreen,
                    BottomNavigationScreens.SettingsScreen,
                )
            )
        }
    ) {
        Column {
            Text(
                text = "Puppies waiting for You",
                modifier = Modifier.padding(8.dp),
                fontSize = 24.sp,
            )
            LastSeenSection(navController, lastSeenPuppies)
            Spacer(modifier = Modifier.size(8.dp))
            AllPuppiesListSection(navController, puppies)
        }
    }
}

@Composable
fun BottomBar(
    navController: NavController,
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