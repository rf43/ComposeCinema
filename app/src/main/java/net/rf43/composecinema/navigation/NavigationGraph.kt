package net.rf43.composecinema.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.rf43.composecinema.detail.DetailScreenRoute
import net.rf43.composecinema.detail.DetailScreenViewModel
import net.rf43.composecinema.home.HomeScreenRoute
import net.rf43.composecinema.home.HomeScreenViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String = ScreenRoute.HOME.route
) {
    NavHost(navController, startDestination) {
        composable(route = ScreenRoute.HOME.route) {
            HomeScreenRoute(viewModel = HomeScreenViewModel()) {
                navController.navigate(ScreenRoute.DETAIL.route)
            }
        }
        composable(route = ScreenRoute.DETAIL.route) {
            DetailScreenRoute(viewModel = DetailScreenViewModel()) {
                navController.navigate(ScreenRoute.HOME.route)
            }
        }
    }
}