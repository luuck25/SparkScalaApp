package com.test.programs

object uppercasealternate extends App {

  val name="lakesh"
  var name1: String = ""

  for( w <- 0 to name.length-1)
  {
    if(w%2==0)  name1=name1+name.charAt(w).toUpper
    else name1=name1+name.charAt(w)

  }

  println(name1)

}
