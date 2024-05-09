package com.example.android_recompositionandstate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.android_recompositionandstate.navigation.NavigationItem
import com.example.android_recompositionandstate.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PemainApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Gery App",
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = stringResource(id = R.string.app_name),
                            modifier = Modifier
                                .size(30.dp)
                                .offset(x = 275.dp)
                        )
                    }
                },

            )

},
        bottomBar = {
            BottomBar(navController)
        },
        modifier = Modifier
    ) { contentPadding ->
        NavHost(
            navController = navController ,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(contentPadding)
        ) {
            composable(Screens.Home.route){
                HomeScreen(navController)
            }
            composable(Screens.List.route){
                ListScreen()
            }
            composable(Screens.About.route){
                AboutScreen()
            }
            composable(
                Screens.Detail.route + "/{pemainId}",
                arguments = listOf(navArgument("pemainId"){ type = NavType.IntType })
            ){navBackStackEntry ->
                DetailScreen(modifier = Modifier, navController = navController,
                    pemainsId  = navBackStackEntry.arguments?.getInt("pemainId")
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = Modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screens = Screens.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_list),
                icon = Icons.Default.List,
                screens = Screens.List
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.Info,
                screens = Screens.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screens.route,
                onClick = {
                    navController.navigate(item.screens.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}
