package com.example.newsapi.presentation.details_news.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.newsapi.ui.spacing

@Composable
fun NewsDetailsColumn(
    label: String,
    separator: @Composable (ColumnScope.() -> Unit) = {},
    labelStyle: TextStyle = MaterialTheme.typography.body1,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "$label ",
            style = labelStyle,
            fontWeight = FontWeight.Bold,
        )
        separator()
    }
}