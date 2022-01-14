package com.example.newsapi.presentation.blog_expandable_list.components

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.core.content.ContextCompat
import com.example.newsapi.R
import com.example.newsapi.common.Constants
import com.example.newsapi.data.remote.dto.BlogsListDto
import com.example.newsapi.presentation.common_components.ButtonWeb
import com.example.newsapi.ui.spacing
import com.example.newsapi.ui.theme.CardCollapsedBackgroundColor
import com.example.newsapi.ui.theme.CardExpandedBackgroundColor

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ExpandableList(
    card: BlogsListDto,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
) {
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = Constants.EXPAND_ANIMATION_DURATION)
    }, label = "bgColorTransition") {
        if (expanded) CardExpandedBackgroundColor else CardCollapsedBackgroundColor
    }
    val cardPaddingHorizontal by transition.animateDp({
        tween(durationMillis = Constants.EXPAND_ANIMATION_DURATION)
    }, label = "paddingTransition") {
        if (expanded) MaterialTheme.spacing.extraLarge else MaterialTheme.spacing.large
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = Constants.EXPAND_ANIMATION_DURATION)
    }, label = "elevationTransition") {
        if (expanded) MaterialTheme.spacing.large else MaterialTheme.spacing.extraSmall
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = Constants.EXPAND_ANIMATION_DURATION,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        if (expanded) MaterialTheme.spacing.default else MaterialTheme.spacing.medium
    }

    Card(
        backgroundColor = cardBgColor,
        contentColor = Color(
            ContextCompat.getColor(
                LocalContext.current,
                R.color.black
            )
        ),
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = cardPaddingHorizontal,
                vertical = MaterialTheme.spacing.small
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                CardArrow(
                    onClick = onCardArrowClick,
                    card = card
                )
            }
            ExpandableContent(visible = expanded, card)
        }
    }
}

@Composable
fun CardArrow(
    onClick: () -> Unit,
    card: BlogsListDto
) {
    IconButton(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small),
        onClick = onClick,
        content = {
            Text(text = card.title, fontWeight = FontWeight.SemiBold)
        }
    )
}

@Composable
fun ExpandableContent(
    visible: Boolean = true,
    card: BlogsListDto
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = Constants.FADE_IN_ANIMATION_DURATION,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(Constants.EXPAND_ANIMATION_DURATION))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = Constants.FADE_OUT_ANIMATION_DURATION,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(Constants.COLLAPSE_ANIMATION_DURATION))
    }
    AnimatedVisibility(
        visible = visible,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = card.summary)
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))

            ButtonWeb(card.url)

        }
    }
}