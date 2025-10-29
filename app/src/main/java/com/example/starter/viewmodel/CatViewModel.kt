package com.example.starter.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starter.App.Companion.app
import com.example.starter.model.Cat
import com.example.starter.repository.CatsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {

    val cats = MutableStateFlow(listOf<Cat>())
    val isLoading = MutableStateFlow(false)

    //Using a public mutable variables for simplicity.
    //The recommended ("official") pattern is to
    //keep the mutable version private and expose it as immutable StateFlow
    //to prevent external classes from modifying the state.

    //Example:
    //private val _test = MutableStateFlow("initValue")
    //val test = _test.asStateFlow()

    init {
        if (!isLoading.value) {
            isLoading.value = true
            viewModelScope.launch {
                cats.value = CatsRepository.getAllCats()
                delay(300)
                isLoading.value = false
            }
        }
    }

    fun selectRandomCat() {
        if (cats.value.isNotEmpty()) Toast.makeText(
            app,
            cats.value.random().name,
            Toast.LENGTH_SHORT
        ).show()
    }
}