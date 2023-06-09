package com.phoenixredwolf.newyorkcityschools.utility

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.phoenixredwolf.newyorkcityschools.data.model.School

@Composable
fun StringHyperlink(url: String, navController: NavController) {
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
                    val uri = stringAnnotation.item
                    navController.navigate("Web/$uri")
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

fun getBoroName(boroname: String): String {
    val result: String
    when (boroname) {
        "SELECT_BORO" -> result = "SELECT BORO"
        "STATEN_ISLAND" -> result = "STATEN ISLAND"
        else -> result = boroname
    }
    return result
}