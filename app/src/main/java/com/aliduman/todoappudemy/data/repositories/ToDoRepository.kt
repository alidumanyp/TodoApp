package com.aliduman.todoappudemy.data.repositories

import com.aliduman.todoappudemy.data.ToDoDao
import com.aliduman.todoappudemy.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val dao: ToDoDao){

    val getAllTasks: Flow<List<ToDoTask>> = dao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = dao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = dao.sortByHighPriority()

    fun getSelectedTask(taskId: Int) : Flow<ToDoTask> {
        return dao.getSelectedTask(taskId=taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        dao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        dao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        dao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTask() {
        dao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String) : Flow<List<ToDoTask>> {
        return dao.searchDatabase(searchQuery = searchQuery)
    }

}