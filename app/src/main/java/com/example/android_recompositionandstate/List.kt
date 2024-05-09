package com.example.android_recompositionandstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_recompositionandstate.component.GambarItem
import com.example.android_recompositionandstate.data.DataPemain
import com.example.android_recompositionandstate.data.ListGambar

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    gambar: List<ListGambar> = DataPemain.ListGambar
){
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Adaptive(140.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
    ){
        items(gambar, key = { it.id }) {
            GambarItem(gambar = it)
        }
    }

}