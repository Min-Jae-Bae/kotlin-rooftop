package com.example.kbsc_cooperate.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.base.Result
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text


internal const val KEY_ARG_DETAILS_ROOFTOP_NAME = "KEY_ARG_DETAILS_ROOFTOP_NAME"

fun launchDetailsActivity(context: Context, item: ExploreModel) {
    context.startActivity(createDetailsActivityIntent(context, item))
}

@VisibleForTesting
fun createDetailsActivityIntent(context: Context, item: ExploreModel): Intent {
    val intent = Intent(context, DetailsActivity::class.java)
    intent.putExtra(KEY_ARG_DETAILS_ROOFTOP_NAME, item.rooftop.name)
    return intent
}

@AndroidEntryPoint
class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            KBSC_CooperateTheme {
                Surface {
                    DetailsScreen(
                        onErrorLoading = { finish() },
                        modifier = Modifier
                            .statusBarsPadding()
                            .navigationBarsPadding()
                    )
                }
            }
        }
    }
}

private data class DetailsScreenUiState(
    val exploreModel: ExploreModel? = null,
    val isLoading: Boolean = false,
    val throwError: Boolean = false
)

@Composable
fun DetailsScreen(
    onErrorLoading: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = viewModel()
) {
    val uiState by produceState(
        key1 = viewModel,
        initialValue = DetailsScreenUiState(isLoading = true)
    ) {
        val rooftopDetailsResult = viewModel.rooftopDetails
        value = if (rooftopDetailsResult is Result.Success<ExploreModel>) {
            DetailsScreenUiState(rooftopDetailsResult.data)
        } else {
            DetailsScreenUiState(throwError = true)
        }
    }

    Crossfade(targetState = uiState, modifier) { currentUiState ->
        when {
            currentUiState.exploreModel != null -> {
            }
        }

    }

}

@Composable
fun DetailsContent(
    exploreModel: ExploreModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Spacer(Modifier.height(32.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = exploreModel.rooftop.nameToDisplay,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
            )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = exploreModel.description,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))



    }

}