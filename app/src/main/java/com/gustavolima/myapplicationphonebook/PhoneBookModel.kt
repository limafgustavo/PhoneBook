package com.gustavolima.myapplicationphonebook

import kotlin.random.Random

data class PhoneBookModel(
    var id: Int = getAutoId(),
    var name: String = "",
    var number:String = ""
) {
   companion object{
       fun getAutoId():Int{
           val random = java.util.Random()
           return  random.nextInt(100)
       }
   }
}