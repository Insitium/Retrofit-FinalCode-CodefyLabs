package com.example.retrofittutorialcodefylabs.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittutorialcodefylabs.network.JsonApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface JsonViewState{
    data class Success(val jsonData: String) : JsonViewState
    object Error : JsonViewState
    object Loading: JsonViewState
}
class JsonViewModel: ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var jsonViewState: JsonViewState by mutableStateOf(JsonViewState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getJsonData()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getJsonData() {
        viewModelScope.launch {
            jsonViewState = try {
                val listResult = JsonApi.retrofitService.getJsonDataFromInternet()
                JsonViewState.Success(
                "Success: ${listResult.size} Json Data retrieved"
                    )}
        catch (e: IOException){
            JsonViewState.Error
        }
        }
    }
}

