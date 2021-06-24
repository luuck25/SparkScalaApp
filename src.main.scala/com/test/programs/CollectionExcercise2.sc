package com.test.programs

import scala.collection.Map

object CollectionExcercise2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // Scala for the Impatient Cay S. Horstmann
  // WOrdcount Mutable and unmutable map
  
  val words= new Array[String](4)                 //> words  : Array[String] = Array(null, null, null, null)
  
 val sname = Array("I","Am","I","Reena","Harry")  //> sname  : Array[String] = Array(I, Am, I, Reena, Harry)

// Mutuable Map
  val mp = scala.collection.mutable.Map[String,Int]()
                                                  //> mp  : scala.collection.mutable.Map[String,Int] = Map()
  
  for(i<-sname)
  mp(i)=mp.getOrElse(i, 0)+1
  
  mp                                              //> res0: scala.collection.mutable.Map[String,Int] = Map(Reena -> 1, I -> 2, Am 
                                                  //| -> 1, Harry -> 1)
  
  // with out Mutable
  
    var mp1 = scala.collection.immutable.Map[String,Int]()
                                                  //> mp1  : scala.collection.immutable.Map[String,Int] = Map()
  
  	for(i<-sname)
  mp1=mp1+(i->(mp1.getOrElse(i, 0)+1))
  
  mp1                                             //> res1: scala.collection.immutable.Map[String,Int] = Map(I -> 2, Am -> 1, Reen
                                                  //| a -> 1, Harry -> 1)
  
  
}