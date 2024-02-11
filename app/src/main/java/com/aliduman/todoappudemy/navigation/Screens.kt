package com.aliduman.todoappudemy.navigation

import androidx.navigation.NavHostController
import com.aliduman.todoappudemy.util.Action
import com.aliduman.todoappudemy.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

}