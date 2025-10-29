package com.example.starter.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starter.App.Companion.app
import com.example.starter.model.Dinosaur
import com.example.starter.repository.DinosaurRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DinosaurViewModel : ViewModel() {

    val dinosaurs = MutableStateFlow(listOf<Dinosaur>())
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
                dinosaurs.value = DinosaurRepository.getAllDinosaurs()
                delay(300)
                isLoading.value = false
            }
        }
    }

    fun selectRandomDinosaur() {
        if (dinosaurs.value.isNotEmpty()) Toast.makeText(
            app,
            dinosaurs.value.random().name,
            Toast.LENGTH_SHORT
        ).show()
    }
}