package com.example.meditationui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditationui.ui.theme.ButtonBlue
import com.example.meditationui.ui.theme.DarkerButtonBlue
import com.example.meditationui.ui.theme.DeepBlue
import com.example.meditationui.ui.theme.LightRed
import com.example.meditationui.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()

    ) {
            Column {
                GreetingSection()
                ChipSection(chips = listOf("Sweet sleep","Insomnia", "Depression", "Night", "Day"))
                CurrentMeditation()
            }
    }
}

@Composable
fun GreetingSection(
    name: String = "Marcin"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Szukaj",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed

) {
    var playMeditation by remember {
        mutableStateOf(0)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Meditation 3 -10 min",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable { playMeditation = playMeditation
                }
                .clip(CircleShape)
                .background(
                    if (playMeditation == playMeditation) ButtonBlue
                    else DarkerButtonBlue)
                .padding(10.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "PLAY",
                tint = Color.White,
                modifier = Modifier.size(16.dp)

            )
        }


    }
}