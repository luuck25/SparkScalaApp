package com.test.programs

object recur {
  def countConsecutiveCharacters(str: String): String = {
  @annotation.tailrec
  def loop(remaining: List[Char], currentChar: Char, currentCount: Int,
           acc: String,acc1:StringBuilder): String =
    remaining match {
      case char :: xs if(char == currentChar) =>
      println(remaining+""+currentChar+""+currentCount+" "+acc)
        loop(
          remaining = xs,
          currentChar,
          currentCount + 1,
          acc,acc1
        )
      
      case char :: xs =>
        println("add"+remaining+""+currentChar+""+currentCount+""+acc)
        loop(
          remaining = xs,
          currentChar = char,
          currentCount = 1,
          acc=acc1.toString(),
          acc1= acc1.append(currentCount.toString+currentChar)
        )
      
      case Nil =>
       acc
    }
  
  str.toList match {
    case char :: list =>
      loop(
        remaining = list,
        currentChar = char,
        currentCount = 1,
        acc = ""
        ,new StringBuilder("")
      )
    
    case Nil =>
     ""
  }
}
  
  def main(args:Array[String])
  {println(countConsecutiveCharacters("AAABBACCBBBA")) 
  }
  


}