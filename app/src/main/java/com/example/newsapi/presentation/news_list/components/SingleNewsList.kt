package com.example.newsapi.presentation.news_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.example.newsapi.data.remote.dto.NewsListDto
import com.example.newsapi.ui.spacing
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SingleNewsList(
    finalSpaceItemDto: NewsListDto,
    onItemClick: (NewsListDto) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
            .clickable { onItemClick(finalSpaceItemDto) }

    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = MaterialTheme.spacing.extraSmall,
        ) {
            Box(modifier = Modifier.size(MaterialTheme.spacing.others)) {
                GlideImage(
                    imageModel = finalSpaceItemDto.imageUrl,
                    contentScale = ContentScale.Crop,
                    circularReveal = CircularReveal(duration = 250),
                )
                Text(
                    text = finalSpaceItemDto.title,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                0F to Color.Transparent,
                                .5F to Color.Black,
                                1F to Color.Black
                            )
                        )
                        .padding(
                            start = MaterialTheme.spacing.medium,
                            end = MaterialTheme.spacing.medium,
                            bottom = MaterialTheme.spacing.medium,
                            top = MaterialTheme.spacing.large
                        ),
                    color = Color.White,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start
                )
            }
        }
        Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
    }
}
