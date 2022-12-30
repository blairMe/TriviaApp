package bfa.blair.triviaapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import bfa.blair.triviaapp.screens.QuestionsViewModel
import bfa.blair.triviaapp.ui.theme.TriviaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    TriviaHome()
                }
            }
        }
    }
}

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Question(viewModel)
}

@Composable
fun Question(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if(viewModel.data.value.loading == true) {
        Log.d("Data Size", "Questions still loading")
    } else {
        Log.d("Data Size", "Stopped loading")
        questions?.forEach{questionItem ->
            Log.d("Data Size", "Result: ${questionItem.question}")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriviaAppTheme {

    }
}