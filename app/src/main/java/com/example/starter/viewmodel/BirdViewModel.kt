package com.example.starter.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starter.App.Companion.app
import com.example.starter.model.Bird
import com.example.starter.repository.BirdsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BirdViewModel : ViewModel() {

    val birds = MutableStateFlow(listOf<Bird>())
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
                birds.value = BirdsRepository.getAllBirds()
                delay(300)
                isLoading.value = false
            }
        }
    }

    fun selectRandomBird() {
        if (birds.value.isNotEmpty()) Toast.makeText(
            app,
            birds.value.random().name,
            Toast.LENGTH_SHORT
        ).show()
    }
}