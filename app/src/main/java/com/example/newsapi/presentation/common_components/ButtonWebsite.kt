package com.example.newsapi.presentation.common_components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.newsapi.R
import com.example.newsapi.ui.theme.LightBlue

@Composable
fun ButtonWeb(links: String) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(links)) }

    Button(modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(backgroundColor = LightBlue),
        onClick = { context.startActivity(intent) }) {
        androidx.compose.material.Text(
            text = stringResource(id = R.string.website),
            style = MaterialTheme.typography.h6,
            color = Color.White
        )
    }
}