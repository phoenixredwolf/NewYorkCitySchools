package com.phoenixredwolf.newyorkcityschools.utility

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import com.phoenixredwolf.newyorkcityschools.data.model.School

@Composable
fun StringHyperlink(url: String) {
    val annotatedLinkString = buildAnnotatedString {

        val link = "https://$url"
        val startIndex = 0
        val endIndex = link.length

        append(link)
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )
        addStringAnnotation(
            tag = "URL",
            annotation = "https://$url",
            start = startIndex,
            end = endIndex
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString.getStringAnnotations("URL", it, it).firstOrNull()
                ?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        })
}

fun getNeighborhoods(schools: List<School>): List<String> {
    val neighborhoods = mutableSetOf<String>()
    schools.forEach {
        it.neighborhood?.let { it1 -> neighborhoods.add(it1) }
    }
    return neighborhoods.toList()
}