package com.phoenixredwolf.newyorkcityschools.component

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewComponent(
    url: String, modifier: Modifier) {

    val address = "https://$url"
    Box(modifier = modifier){
        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                val webSettings = settings
                webSettings.loadWithOverviewMode = true
                webSettings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(address)
            }
        }, update =  {
            it.loadUrl(address)
        })

    }
}

