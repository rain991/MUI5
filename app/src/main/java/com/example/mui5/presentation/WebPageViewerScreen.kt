package com.example.mui5.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mui5.data.parceUrl


@Composable
fun WebPageViewerScreen(paddingValues: PaddingValues) {
    var currentUrl by remember { mutableStateOf("") }
    var webViewVisible by remember { mutableStateOf(false) }
    var inputUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Web Viewer",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.W500)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            if (webViewVisible) {
                IconButton(onClick = {
                    webViewVisible = false
                    currentUrl = ""
                    inputUrl = ""
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
            WebViewerInputField(
                modifier = Modifier.weight(1f),
                url = inputUrl,
                onUrlChange = { inputUrl = it },
                onGoAction = {
                    if (inputUrl.isNotBlank()) {
                        currentUrl = parceUrl(inputUrl)
                        webViewVisible = true
                    }
                }
            )
        }

        AnimatedVisibility(visible = webViewVisible) {
            WebViewer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                url = currentUrl
            )
        }
    }
}