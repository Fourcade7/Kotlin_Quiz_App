package com.pr7.kotlin_quiz_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.pr7.kotlin_quiz_app.data.model.QuestionModel
import com.pr7.kotlin_quiz_app.data.repository.QuestionRepository
import com.pr7.kotlin_quiz_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var questionRepository: QuestionRepository
    lateinit var arrayList: ArrayList<QuestionModel>
    lateinit var questionModel: QuestionModel
    var trueanswer=0
    var falseanswer=0
    var count = 0
    var cheked=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        questionRepository = QuestionRepository()
        arrayList = questionRepository.getAllQuestions()
        //arrayList.shuffle()

        setQuestions()

        binding.apply {
            textviewnext.setOnClickListener {
                setQuestions()
            }
            textviewoption1.setOnClickListener {
                checkanswers(questionModel,textviewoption1)
            }
            textviewoption2.setOnClickListener {
                checkanswers(questionModel,textviewoption2)
            }
            textviewoption3.setOnClickListener {
                checkanswers(questionModel,textviewoption3)
            }
            textviewoption4.setOnClickListener {
                checkanswers(questionModel,textviewoption4)
            }
        }


    }


    fun setQuestions() {
        binding.apply {
            checkanswerlimit()
            imageviewquestion.setImageResource(questionModel.image)
            val arraylist= arrayListOf(
                questionModel.option1,
                questionModel.option2,
                questionModel.option3,
                questionModel.option4,
            )
            arraylist.shuffle()
            textviewoption1.text = arraylist.get(0)
            textviewoption2.text = arraylist.get(1)
            textviewoption3.text = arraylist.get(2)
            textviewoption4.text = arraylist.get(3)
            clearcheckcolor()
            cheked=true
        }
    }

    fun checkanswerlimit() {
        title="count=${count}, q}"

        if (count < arrayList.size) {
            questionModel=arrayList.get(count)
            title="count=${count}, q ${arrayList.get(count).question}"
        }
        if (count==arrayList.size-1){
            binding.textviewnext.text="finish"
        }

        if (count==arrayList.size){
           endgame()
        }
        if (count==arrayList.size+1){
            restart()
        }
        count++


    }

    fun endgame(){
        binding.apply {
            linearlay1.gone()
            textviewnext.text="restart ?"
            textviewtrueorfalseanswer.visible()
            textviewtrueorfalseanswer.text="True $trueanswer\nFalse $falseanswer"
        }
    }

    fun restart(){
        count=0
        setQuestions()
        trueanswer=0
        falseanswer=0
        binding.apply {
            linearlay1.visible()
            textviewnext.text="next"
            textviewtrueorfalseanswer.gone()
        }
    }

    fun checkanswers(questionModel: QuestionModel,view: TextView){
       binding.apply {
           if (view.text.toString()==questionModel.answer){
               //showtoast(this@MainActivity,"true")
               checkcolor(true,view)
               if (cheked){
                   trueanswer++
                   cheked=false
               }
           }else{
               //showtoast(this@MainActivity,"false")
               checkcolor(false,view)
               if (cheked){
                   cheked=false
                   falseanswer++
               }

           }

       }
    }

    fun checkcolor(trueorfalse:Boolean,view: TextView){
        if (trueorfalse){
            view.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.background_green)
        }else{
            view.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.background_red)
        }
    }
    fun clearcheckcolor(){
        binding.apply {
            textviewoption1.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.background_transparent)
            textviewoption2.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.background_transparent)
            textviewoption3.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.background_transparent)
            textviewoption4.background=ContextCompat.getDrawable(this@MainActivity,R.drawable.background_transparent)
        }
    }

}