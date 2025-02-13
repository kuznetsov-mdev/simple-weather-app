package ru.sandbox.swa.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.usecase.GetCitiesUseCase
import ru.sandbox.swa.usecase.GetLastSearchedCityUseCase
import ru.sandbox.swa.usecase.SaveCityToSearchHistoryUseCase
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SearchViewModel @Inject constructor(
    @Named("openWeatherApiKey")
    private val apiKey: String,
    private val searchCityUseCase: GetCitiesUseCase,
    private val getLastSearchedCityUseCase: GetLastSearchedCityUseCase,
    private val saveCityToSearchHistoryUseCase: SaveCityToSearchHistoryUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching: StateFlow<Boolean> = _isSearching.asStateFlow()

    private val _searchHistory = MutableStateFlow<CityItem?>(null)
    val searchHistory = _searchHistory.asStateFlow()

    private val _cities = MutableStateFlow(listOf<CityItem>())

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val cities: StateFlow<List<CityItem>> = searchQuery
        .debounce(850)
        .distinctUntilChanged()
        .onEach { _isSearching.update { true } }
        .mapLatest { getCitiesByQuery(it) }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(500),
            _cities.value
        )

    fun onSearchQueryChanged(searchQuery: String) {
        _searchQuery.value = searchQuery
    }

    fun saveSearchHistory(cityModel: CityItem) {
        viewModelScope.launch(Dispatchers.IO) {
            saveCityToSearchHistoryUseCase(cityModel)
        }
    }

    fun getLastSearchedCity() {
        viewModelScope.launch(Dispatchers.IO) {
            getLastSearchedCityUseCase().collectLatest {
                _searchHistory.value = it
            }
        }
    }

    private suspend fun getCitiesByQuery(query: String): List<CityItem> {
        return if (query.isNotBlank()) {
            searchCityUseCase(query, 30, apiKey)
        } else {
            emptyList()
        }
    }
}