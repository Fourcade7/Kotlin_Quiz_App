package com.pr7.kotlin_quiz_app

import android.content.Context
import android.view.View
import android.widget.Toast


fun View.visible(){
    this.visibility=View.VISIBLE
}
fun View.gone(){
    this.visibility=View.GONE
}

fun MainActivity.showtoast(context:Context,text:String){
    Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
}