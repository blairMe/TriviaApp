package bfa.blair.triviaapp.component

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import bfa.blair.triviaapp.screens.QuestionsViewModel

@Composable
fun Question(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if(viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("Data Size", "Questions still loading")
    } else {
        Log.d("Data Size", "Stopped loading")
        questions?.forEach{questionItem ->
            Log.d("Data Size", "Result: ${questionItem.question}")
        }

    }

}