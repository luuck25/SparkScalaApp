package com.test.programs

import scala.collection.mutable.ArrayBuffer

object Collections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  // Arrays fixed size
  
  val samplearray = new Array[Int](10)            //> samplearray  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
 
 // Iterate
  for(a<-0 until samplearray.length) samplearray(a)=a*a
  
  samplearray                                     //> res0: Array[Int] = Array(0, 1, 4, 9, 16, 25, 36, 49, 64, 81)
  
  // Iterate way 2
  
  for(ele<- samplearray) print(ele)               //> 0149162536496481
 
 // varible lenth Array ArrayBuffer
  
  
  val vararray = new ArrayBuffer[Int]             //> vararray  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  
  
  vararray+=1                                     //> res1: com.test.programs.Collections.vararray.type = ArrayBuffer(1)
  
  vararray+=(1,2,3)                               //> res2: com.test.programs.Collections.vararray.type = ArrayBuffer(1, 1, 2, 3)
                                                  //| 
  
  vararray++=Array(9,9,10)                        //> res3: com.test.programs.Collections.vararray.type = ArrayBuffer(1, 1, 2, 3, 
                                                  //| 9, 9, 10)
  vararray.remove(1)                              //> res4: Int = 1
  
  vararray                                        //> res5: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 9, 9,
                                                  //|  10)
 vararray.insert(2, 99)
 
 vararray                                         //> res6: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 99, 3, 9
                                                  //| , 9, 10)
 
 
 // Array Transformations
 
 val a = Array(1,2,3,4,5)                         //> a  : Array[Int] = Array(1, 2, 3, 4, 5)
 
 val b = for(ele<-a) yield ele*2                  //> b  : Array[Int] = Array(2, 4, 6, 8, 10)
 // use a gaurd to keep only wanted stuff
 a                                                //> res7: Array[Int] = Array(1, 2, 3, 4, 5)
 val c = for(ele<-a if ele%2==0) yield ele*2      //> c  : Array[Int] = Array(4, 8)
 
 
 a.toString()                                     //> res8: String = [I@6536e911
 
 a.mkString("[", ",", "]")                        //> res9: String = [1,2,3,4,5]
 
 
 
 
}