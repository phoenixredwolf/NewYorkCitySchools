package com.phoenixredwolf.newyorkcityschools.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phoenixredwolf.newyorkcityschools.data.model.Boro
import com.phoenixredwolf.newyorkcityschools.data.model.SatScore
import com.phoenixredwolf.newyorkcityschools.data.model.School
import com.phoenixredwolf.newyorkcityschools.data.model.getBoro
import com.phoenixredwolf.newyorkcityschools.data.repository.Repository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {



    private val _schoolResponse = MutableStateFlow(emptyList<School>())
    val schoolsResponse: StateFlow<List<School>>
        get() = _schoolResponse

    private val _selectedBoro : MutableStateFlow<Boro?> = MutableStateFlow(null)
    val selectedBoro : StateFlow<Boro?>
        get() = _selectedBoro

    private val _satResponse = MutableStateFlow(emptyList<SatScore>())
    val satResponse: StateFlow<List<SatScore?>>
        get() = _satResponse

    private val _isLoading = MutableStateFlow(false)
    val isLoading : StateFlow<Boolean> = _isLoading

    private val _isError = MutableStateFlow(false)
    val isError : StateFlow<Boolean> = _isError

    private val errorHandler = CoroutineExceptionHandler {
            _, error ->
        if(error is Exception) {
            _isError.value = true
        }
    }

    fun getAllSchools() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            _schoolResponse.value = repository.getAllSchools()
            _isLoading.value = false
        }
    }

    fun getSchoolByBoro(boro: String) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            _schoolResponse.value = repository.getBoroSchools(boro)
            _isLoading.value = false
        }
    }

    fun getSchoolByNeighborhood(neighborhood: String) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            _schoolResponse.value = repository.getNeighborhoodSchools(neighborhood)
            _isLoading.value = false
        }
    }

    fun onSelectedBoroChanged(boro: String) {
        val newBoro = getBoro(boro)
        _selectedBoro.value = newBoro
    }

    fun getSatScores(dbn: String) {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            _satResponse.value = repository.getSatScoresForSchool(dbn)
        }
    }

}