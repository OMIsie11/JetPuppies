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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.omisie11.jetpuppies.data.lastSeenPuppies
import io.github.omisie11.jetpuppies.data.puppies
import io.github.omisie11.jetpuppies.ui.theme.JetPuppiesTheme

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
        Column {
            Text(
                text = "Puppies waiting for You",
                modifier = Modifier.padding(8.dp),
                fontSize = 24.sp,
            )
            LastSeenSection(lastSeenPuppies)
            Spacer(modifier = Modifier.size(8.dp))
            AllPuppiesListSection(puppies)
        }
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

@Preview
@Composable
fun MainScreenPreview() {
    JetPuppiesTheme {
        MainScreen()
    }
}