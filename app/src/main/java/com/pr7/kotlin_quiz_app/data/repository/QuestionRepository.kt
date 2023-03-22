package com.pr7.kotlin_quiz_app.data.repository

import com.pr7.kotlin_quiz_app.data.model.QuestionModel
import com.pr7.kotlin_quiz_app.R

class QuestionRepository {


    fun getAllQuestions():ArrayList<QuestionModel> = arrayListOf(
        QuestionModel(question = "This is 1 ?", image = R.drawable.adobe, option1 = "Adobe", option2 = "Google", option3 = "Yandex", option4 = "Youtube", answer = "Adobe"),
        QuestionModel(question = "This is 2 ?", image = R.drawable.google, option1 = "Google", option2 = "Firebase", option3 = "Swift", option4 = "Adobe", answer = "Google"),
        QuestionModel(question = "This is 3 ?", image = R.drawable.yandex, option1 = "Yandex", option2 = "Youtube", option3 = "Google", option4 = "Swift", answer = "Yandex"),
        QuestionModel(question = "This is 4 ?", image = R.drawable.youtube, option1 = "Youtube", option2 = "Yandex", option3 = "Firebase", option4 = "Adobe", answer = "Youtube"),
        QuestionModel(question = "This is 5 ?", image = R.drawable.firebase, option1 = "Firebase", option2 = "Swift", option3 = "Youtube", option4 = "Google", answer = "Firebase"),
        QuestionModel(question = "This is 6 ?", image = R.drawable.swift, option1 = "Swift", option2 = "Adobe", option3 = "Yandex", option4 = "Firebase", answer = "Swift"),
    )
}