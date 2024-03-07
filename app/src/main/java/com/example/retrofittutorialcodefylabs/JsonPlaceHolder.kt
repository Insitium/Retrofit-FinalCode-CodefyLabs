package com.example.retrofittutorialcodefylabs

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.retrofittutorialcodefylabs.screens.HomeScreen
import com.example.retrofittutorialcodefylabs.screens.JsonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JsonPlaceholder() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val jsonUiModel: JsonViewModel = viewModel()
            HomeScreen(jsonUiState = jsonUiModel.jsonViewState,
                contentPadding = it,
            )
        }
    }
}