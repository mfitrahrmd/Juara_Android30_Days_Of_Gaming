package com.mfitrahrmd.juara_android_30_days_of_gaming

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mfitrahrmd.juara_android_30_days_of_gaming.model.GamingTodo
import com.mfitrahrmd.juara_android_30_days_of_gaming.ui.theme.Juara_Android30_Days_Of_GamingTheme

@Composable
fun GamingItem(gamingTodo: GamingTodo) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.day, gamingTodo.day),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.End)
            )
            Text(
                text = stringResource(id = gamingTodo.titleRes),
                style = MaterialTheme.typography.titleMedium
            )
            Image(
                painter = painterResource(id = gamingTodo.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(vertical = 4.dp)
            )
            if (isExpanded) Text(
                text = stringResource(id = gamingTodo.descriptionRes),
                style = MaterialTheme.typography.bodyLarge
            )
            IconButton(
                onClick = {
                    isExpanded = !isExpanded
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }
}

@Composable
fun GamingItemList(gamingList: List<GamingTodo>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(
            horizontal = 12.dp,
        )
    ) {
        items(gamingList) { g ->
            GamingItem(g)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GamingItemListPreview() {
    Juara_Android30_Days_Of_GamingTheme {
        GamingItemList(listOf(
            GamingTodo(
                1,
                R.string.dota_ranked,
                R.string.dota_ranked_desc,
                R.drawable.dota
            ),
            GamingTodo(
                2,
                R.string.valorant_ranked,
                R.string.valorant_ranked_desc,
                R.drawable.valorant
            )
        ))
    }
}