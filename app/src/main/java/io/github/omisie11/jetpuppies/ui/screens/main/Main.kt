package io.github.omisie11.jetpuppies.ui.screens.main

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.omisie11.jetpuppies.model.Puppy
import io.github.omisie11.jetpuppies.ui.theme.JetPuppiesTheme

@Composable
fun MainScreen() {

    val lastSeenPuppies = listOf<Puppy>()
    val puppies = listOf<Puppy>(

    )

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
fun LastSeenSection(
    puppies: List<Puppy>
) {
    Column() {
        Text(
            text = "Last seen",
            modifier = Modifier.padding(8.dp),
        )
        Row() {
            puppies.forEach { puppy ->
                PuppyCardItem(item = puppy, onClick = { })
            }
        }
    }
}

@Composable
fun PuppyCardItem(
    item: Puppy,
    onClick: () -> Unit
) {
    Card() {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(8.dp)
        ) {

        }
    }
}

@Composable
fun AllPuppiesListSection(
    puppies: List<Puppy>
) {
    Column() {
        Text(
            text = "All puppies waiting for You!",
            modifier = Modifier.padding(8.dp),
        )
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