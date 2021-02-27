package io.github.omisie11.jetpuppies.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.coil.CoilImage
import io.github.omisie11.jetpuppies.model.Puppy

@Composable
fun LastSeenSection(
    navController: NavController,
    puppies: List<Puppy>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Last seen",
            modifier = Modifier.padding(8.dp),
        )
        LazyRow {
            items(puppies) { puppy ->
                LastSeenPuppyCardItem(
                    puppy = puppy,
                    modifier = Modifier.padding(8.dp),
                    onClick = { navController.navigate("details") }
                )
            }
        }
    }
}

@Composable
fun LastSeenPuppyCardItem(
    puppy: Puppy,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CoilImage(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                data = puppy.mainPhoto,
                contentDescription = null,
                fadeIn = true,
                contentScale = ContentScale.FillBounds,
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = puppy.name,
                textAlign = TextAlign.Center
            )
        }
    }
}