package com.aliduman.todoappudemy.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliduman.todoappudemy.data.models.ToDoTask
import com.aliduman.todoappudemy.data.repositories.ToDoRepository
import com.aliduman.todoappudemy.util.RequestState
import com.aliduman.todoappudemy.util.RequestState.Error
import com.aliduman.todoappudemy.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> = mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks : StateFlow<RequestState<List<ToDoTask>>> = _allTasks

     fun getAllTasks() {
         _allTasks.value = RequestState.Loading

         try {
             viewModelScope.launch {
                 repository.getAllTasks.collect {
                     _allTasks.value = RequestState.Success(it)
                 }
             }
         } catch (e: Exception) {
             _allTasks.value = RequestState.Error(error = e)
         }

     }

}