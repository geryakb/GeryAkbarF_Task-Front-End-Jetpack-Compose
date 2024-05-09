package com.example.android_recompositionandstate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.android_recompositionandstate.data.DataPemain
import com.example.android_recompositionandstate.data.Pemain

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    pemainsId: Int?
) {
    val newPemainsList = DataPemain.Pemain.filter { pemain ->
        pemain.id == pemainsId
    }
    Column(
        modifier = modifier
    ) {
        DetailPemainContent(newPemainsList = newPemainsList)
    }
}

@Composable
private fun DetailPemainContent(
    newPemainsList: List<Pemain>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize().padding(40.dp)
    ) {
        Image(painter = painterResource(id = newPemainsList[0].image),
            contentDescription = null)

        Spacer(modifier = Modifier.height(26.dp))
        Column(modifier = Modifier.padding(4.dp)) {


            Text(
                text = newPemainsList[0].name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Age :(${newPemainsList[0].age})",
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = "Club : ${newPemainsList[0].club}",
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = "Desc : ${newPemainsList[0].description}",
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}








