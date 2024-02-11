package com.aliduman.todoappudemy.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aliduman.todoappudemy.ui.screens.list.ListScreen
import com.aliduman.todoappudemy.ui.viewmodels.SharedViewModel
import com.aliduman.todoappudemy.util.Constants.LIST_ARGUMENT_KEY
import com.aliduman.todoappudemy.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}