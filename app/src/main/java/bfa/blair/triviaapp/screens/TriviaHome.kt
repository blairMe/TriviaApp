package bfa.blair.triviaapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import bfa.blair.triviaapp.component.Question


@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Question(viewModel)
}