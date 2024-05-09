package com.example.android_recompositionandstate.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android_recompositionandstate.data.Club
import com.example.android_recompositionandstate.ui.theme.GreenJC

@Composable
fun ClubItem(
    club: Club,
    modifier: Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ){
        Image(painter = painterResource(id = club.image),
            contentDescription = club.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .size(60.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = club.name, style = MaterialTheme.typography.titleMedium)
            Row{
                Text(text = club.nickname, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
    
}