package io.github.omisie11.jetpuppies.ui.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.chrisbanes.accompanist.coil.CoilImage
import io.github.omisie11.jetpuppies.data.singlePuppy

@Composable
fun DetailsScreen(
    navController: NavController
) {
    val puppy = singlePuppy

    Scaffold(
        topBar = {
            DetailsTopBar(
                navController,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row {
                CoilImage(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(300.dp)
                        .width(300.dp)
                        .clip(CircleShape),
                    data = puppy.mainPhoto,
                    contentDescription = null,
                    fadeIn = true,
                    contentScale = ContentScale.FillBounds,
                )
            }
            Text(
                text = puppy.name,
                modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = puppy.breed,
                modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light
                )
            )
            Divider(
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(horizontal = 48.dp, vertical = 8.dp)
            )
            Text(
                text = "Bio",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = puppy.bio,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun DetailsTopBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        },
        actions = {
            IconButton(onClick = {
                // Todo: Favorites functionality
            }) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                )
            }
        }
    )
}