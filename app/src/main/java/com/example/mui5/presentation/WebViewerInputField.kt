package com.example.mui5.presentation

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
fun WebViewerInputField(modifier : Modifier, onGoAction: (String) -> Unit) {
    var url by remember { mutableStateOf("") }
    TextField(
        value = url,
        onValueChange = { url = it },
        label = { Text("Enter URL") },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default .copy(imeAction = ImeAction.Go),
        keyboardActions = KeyboardActions(onGo = {

        }),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}