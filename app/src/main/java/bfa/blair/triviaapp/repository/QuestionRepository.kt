package bfa.blair.triviaapp.repository

import android.util.Log
import bfa.blair.triviaapp.data.DataOrException
import bfa.blair.triviaapp.model.QuestionItem
import bfa.blair.triviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api : QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions() : DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("EXC", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}