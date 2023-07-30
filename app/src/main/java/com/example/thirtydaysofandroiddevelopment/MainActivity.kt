package com.example.thirtydaysofandroiddevelopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysofandroiddevelopment.model.Tip
import com.example.thirtydaysofandroiddevelopment.model.TipData.tips
import com.example.thirtydaysofandroiddevelopment.ui.theme.ThirtyDaysOfAndroidDevelopmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfAndroidDevelopmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ThirtyDaysOfAndroidApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ThirtyDaysOfAndroidApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.displayLarge
                        )

                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.top_bar_spacer)))

                        Icon(
                            painter = painterResource(id = R.drawable.ic_android_green_30dp),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        modifier = modifier
    ) { it->
        LazyColumn(contentPadding = it) {
            items(tips) {
                TipItem(
                    tip = it
                )
            }
        }
    }
}

@Composable
private fun TipItem(tip: Tip, modifier: Modifier = Modifier) {
    var descriptionVisibility by remember { mutableStateOf(false) }

    Card(modifier = modifier
        .fillMaxWidth()
        .padding(dimensionResource(R.dimen.padding_medium))
        .clip(MaterialTheme.shapes.small),
    ) {
        Column(modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(tip.dayOfTheMonth),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_extra_small))
            )

            Text(
                text = stringResource(tip.tipSummary),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.padding_small))
            )

            Image(
                painter = painterResource(tip.tipImage),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.padding_medium))
                    .fillMaxWidth()
                    .clickable { descriptionVisibility = !descriptionVisibility },
                contentScale = ContentScale.FillWidth,
            )

            AnimatedVisibility(
                visible = descriptionVisibility,
                enter = slideInHorizontally()
                        + fadeIn(),
                exit = slideOutHorizontally(
                    targetOffsetX = { it / 2 }
                )
                        + fadeOut()
            ) {
                Text(
                    text = stringResource(tip.tipDescription),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
private fun TipsList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(tips) {
            TipItem(
                tip = it
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TipItemLightThemePreview() {
    ThirtyDaysOfAndroidDevelopmentTheme(darkTheme = false) {
        TipItem(tips[0])
    }
}

@Preview(showBackground = true)
@Composable
fun TipItemDarkThemePreview() {
    ThirtyDaysOfAndroidDevelopmentTheme(darkTheme = true) {
        TipItem(tips[0])
    }
}

@Preview(showBackground = true)
@Composable
fun TipsListLightThemePreview() {
    ThirtyDaysOfAndroidDevelopmentTheme(darkTheme = false) {
        TipsList()
    }
}