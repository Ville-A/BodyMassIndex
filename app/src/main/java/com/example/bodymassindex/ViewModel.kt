package com.example.bodymassindex

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    val height: Float
        get() = heightInput.toFloatOrNull() ?: 0.0f
    val weight: Float
        get() = weightInput.toFloatOrNull() ?: 0.0f
    val bmi: Float
        get() = calculate()
    fun updateHeight(value: String) {
        heightInput = value
    }
    fun updateWeight(value: String) {
        weightInput = value
    }

    private fun calculate(): Float {
        val heightInMeters = height / 100
        return if (height > 0 && weight > 0) {
            weight / (heightInMeters * heightInMeters)
        } else {
            0.0f
        }
    }
}