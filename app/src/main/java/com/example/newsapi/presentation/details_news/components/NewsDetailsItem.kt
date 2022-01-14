package com.example.newsapi.presentation.details_news.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.newsapi.R
import com.example.newsapi.data.remote.dto.NewsDetailsDto
import com.example.newsapi.presentation.common_components.ButtonWeb
import com.example.newsapi.ui.spacing
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsDetailsItem(newsDetails: NewsDetailsDto, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarNews(navController)
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.small),
        ) {
            item {
                GlideImage(
                    imageModel = newsDetails.imageUrl,
                    contentScale = ContentScale.Crop,
                    circularReveal = CircularReveal(duration = 250)
                )

                Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
            }
            item {
                NewsDetailsColumn(
                    label = stringResource(id = R.string.title),
                    separator = {
                        Text(
                            text = newsDetails.title,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                )
            }
            item {
                NewsDetailsColumn(
                    label = stringResource(id = R.string.news_site),
                    separator = {
                        Text(
                            text = newsDetails.newsSite,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                )
            }
            item {
                NewsDetailsColumn(
                    label = stringResource(id = R.string.summary),
                    separator = {
                        Text(
                            text = newsDetails.summary,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                )
            }
            item {
                Spacer(
                    modifier = Modifier
                        .height(MaterialTheme.spacing.medium)
                )
                ButtonWeb(newsDetails.url)
            }
            item {

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                LazyRow(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                }
            }
        }
    }
}