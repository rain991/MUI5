package com.example.mui5.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter


@Composable
fun WebPageViewerScreen(paddingValues: PaddingValues) {
    var currentUrl by remember { mutableStateOf("") }
    var webViewVisible by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
       Row(modifier = Modifier.fillMaxWidth().weight(1f)){
           if(webViewVisible){
               IconButton(onClick = {  }) {

               }
           }
           WebViewerInputField(modifier = Modifier) { url ->
               if (url.isNotBlank()) {
                   currentUrl = if (url.startsWith("http")) url else "https://$url"
               }
           }
       }


        AnimatedVisibility(visible = webViewVisible) { }
        WebViewer(modifier = Modifier.fillMaxWidth().weight(6f), url = currentUrl)
    }

}

