package com.test.programs

object LearningScala {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  
  2*5                                             //> res0: Int(10) = 10
  
  // Named and Default Argumengts
  
  
  def decorate(str:String,left:String="[",right:String="]")= left+str+right
                                                  //> decorate: (str: String, left: String, right: String)String
  
  decorate("hello")                               //> res1: String = [hello]
   
  decorate("hello",right=">>")                    //> res2: String = [hello>>
  
  decorate("hello","[[")                          //> res3: String = [[hello]
  
  
  // var Args (variable Number of Argumnets mentioned after type with *
  
  def sum(args:Int*)= { //args* is seq[Int]
  
  var result=0
  
  for(arg<- args) result+=arg
  
  result
  }                                               //> sum: (args: Int*)Int
  
 val s= sum(1,2,3,4)                              //> s  : Int = 10
 
 // IF you already have a seq[int] , need decoration to pass it
  
  sum(1 to 10:_*)   // :*_ mean consider as sequence of something
                                                  //> res4: Int = 55
  
  
  val ss ="lakesh"                                //> ss  : String = lakesh
  
  ss.substring(1)                                 //> res5: String = akesh
  
  
  
  def isvowel(ch:Char)= "aieou".contains(ch)      //> isvowel: (ch: Char)Boolean
  
  
  def vowel(s:String)={
  
  for(ch<-s if isvowel(ch)) yield ch
  }                                               //> vowel: (s: String)String
  
  vowel("Nicaragua")                              //> res6: String = iaaua
  
  def vowels3(s:String):String=
  {
	if(s.length()==0) ""
	else
	{
	val ch=s(0)
	
	val rest=vowels3(s.substring(1))
	
	if(isvowel(ch)) ch+rest else rest
	}
  }                                               //> vowels3: (s: String)String
  
  vowels3("Nicaragua")                            //> res7: String = iaaua
    
}