package io.github.omisie11.jetpuppies.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.coil.CoilImage
import io.github.omisie11.jetpuppies.model.Puppy

@Composable
fun AllPuppiesListSection(
    navController: NavController,
    puppies: List<Puppy>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = "All puppies",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )
        )
        Spacer(modifier = Modifier.size(8.dp))
        LazyColumn(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(puppies) { puppy ->
                PuppyListItem(
                    puppy = puppy,
                    onClick = {
                        navController.navigate("details")
                    })
            }
        }
    }
}

@Composable
fun PuppyListItem(
    puppy: Puppy,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        CoilImage(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp)
                .clip(CircleShape),
            data = puppy.mainPhoto,
            contentDescription = null,
            fadeIn = true,
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Text(text = puppy.name)
            Text(text = puppy.breed)
        }
    }
}