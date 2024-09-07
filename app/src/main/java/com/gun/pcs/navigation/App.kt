package com.gun.pcs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gun.pcs.ui.UserDetailScreen
import com.gun.pcs.ui.UserListScreen
import com.gun.pcs.viewmodel.UserViewModel

@Composable
fun App(viewModel: UserViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "userList") {
        composable("userList") {
            UserListScreen(viewModel = viewModel, onUserClick = { user ->
                viewModel.selectUser(user)
                navController.navigate("userDetail")
            })
        }
        composable("userDetail") {
            UserDetailScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
