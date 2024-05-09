package com.example.android_recompositionandstate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.gery),
                contentDescription = null,
                modifier = Modifier
                    .clip(RectangleShape)
                    .size(200.dp))

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Gery Akbar Firmansyah",
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Email :" + " gery.akbar@mhs.itenas.ac.id",
                    fontSize = 17.sp,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Kampus :" + " Institut Teknologi Nasional Bandung",
                    fontSize = 17.sp,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Jurusan :" + " Informatika",
                    fontSize = 17.sp,
                    fontFamily = FontFamily.Serif,
                )
            }
    }
}