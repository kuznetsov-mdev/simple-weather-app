package ru.sandbox.swa.screen.city

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.usecase.GetSearchHistoryUseCase
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase
) : ViewModel() {

    private val _searchedCities = MutableStateFlow<List<CityItem>>(emptyList())
    val searchedCities: StateFlow<List<CityItem>>
        get() = _searchedCities.asStateFlow()

    fun fetchCities() {
        viewModelScope.launch(Dispatchers.IO) {
            _searchedCities.value = getSearchHistoryUseCase()
        }
    }
}