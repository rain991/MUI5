package com.example.mui5.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun WebBrowserApp(paddingValues: PaddingValues) {
    var url by remember { mutableStateOf("") }
    var currentUrl by remember { mutableStateOf("https://www.google.com") }

    Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
        TextField(
            value = url,
            onValueChange = { url = it },
            label = { Text("Enter URL") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default .copy(imeAction = ImeAction.Go),
            keyboardActions = KeyboardActions(onGo = {
                if (url.isNotBlank()) {
                    currentUrl = if (url.startsWith("http")) url else "https://$url"
                }
            }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        WebViewer(modifier = Modifier.weight(1f), url =currentUrl)
    }
}
