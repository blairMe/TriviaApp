package bfa.blair.triviaapp.network

import bfa.blair.triviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions() : Question
}