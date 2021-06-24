package com.assignment.xebia.spark_app

object test1 {
  
  
   def main(args:Array[String])
  {
     
    //  samplehiorder(5, addfive)
     
   // val s = samplehiorder1(true)
     
     print(casest(3))
   //  val returnedFunction = getStrategy(true)
 
  //     print(returnedFunction(15.0))
  }
  
  
  def addfive(number:Int):Int=
  {
    number+5
  }
  
  
  def samplehiorder(number:Int,abc : Int => Int)=
  {
    print(number+abc(number))
    
  }
  
  
  def casest(number:Int):String=number match
  {
    case 1 => "one"
    case 2 => "two"
    case _ => "default"
    
  }
  
 
  def getStrategy(enoughEnergy: Boolean) = {
  if (enoughEnergy)
    (energy: Double) => "We are going to attack with damage "+energy
  else
    (energy: Double) => "We are going to reflect damage "+energy/2
}
  
  def samplehiorder1(a:Boolean) =
  {
    if(a)
      (b:Int) => "its double"+b
    
  }
}