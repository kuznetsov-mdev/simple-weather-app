package ru.sandbox.swa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.sandbox.swa.api.ConnectivityServiceApi
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val connectivityServiceApi: ConnectivityServiceApi
) : ViewModel() {

    private val _networkState: MutableStateFlow<ConnectivityServiceApi.Status> =
        MutableStateFlow(ConnectivityServiceApi.Status.Unavailable)

    val networkState: StateFlow<ConnectivityServiceApi.Status>
        get() = _networkState.asStateFlow()

    fun observeNetworkState() {
        viewModelScope.launch(Dispatchers.IO) {
            connectivityServiceApi.observe().collectLatest { networkStatus ->
                _networkState.update { networkStatus }
            }
        }
    }
}