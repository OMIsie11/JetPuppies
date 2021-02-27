package io.github.omisie11.jetpuppies.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import dev.chrisbanes.accompanist.coil.CoilImage
import io.github.omisie11.jetpuppies.data.singlePuppy
import io.github.omisie11.jetpuppies.ui.theme.JetPuppiesTheme

@Composable
fun DetailsScreen(
    navController: NavController
) {
    val puppy = singlePuppy

    Scaffold(
        topBar = {
            DetailsTopBar(
                navController,
                title = puppy.name,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            CoilImage(data = puppy.mainPhoto) {

            }
        }
    }
}

@Composable
fun DetailsTopBar(
    navController: NavController,
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}