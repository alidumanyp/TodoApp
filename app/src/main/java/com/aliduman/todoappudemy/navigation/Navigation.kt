package com.aliduman.todoappudemy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aliduman.todoappudemy.navigation.destinations.listComposable
import com.aliduman.todoappudemy.navigation.destinations.taskComposable
import com.aliduman.todoappudemy.ui.viewmodels.SharedViewModel
import com.aliduman.todoappudemy.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )

        taskComposable(
            navigateToListScreen = screen.list
        )


    }

}