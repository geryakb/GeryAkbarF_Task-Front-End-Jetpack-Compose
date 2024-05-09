package com.example.android_recompositionandstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_recompositionandstate.component.ClubItem
import com.example.android_recompositionandstate.component.PemainItem
import com.example.android_recompositionandstate.data.Club
import com.example.android_recompositionandstate.data.DataPemain
import com.example.android_recompositionandstate.data.Pemain
import com.example.android_recompositionandstate.navigation.Screens

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier =Modifier,
    pemains: List<Pemain> = DataPemain.Pemain,
    clubs: List<Club> = DataPemain.Club,
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
            ) {
                items(pemains, key = { it.id }) {
                    PemainItem(pemain = it) { pemainId ->
                        navController.navigate(Screens.Detail.route  + "/$pemainId")

                    }
                }
            }
        }
        items(clubs, key = { it.id }) {
            ClubItem(club = it, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }

}