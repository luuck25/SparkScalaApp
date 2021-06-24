package com.test.programs

import scala.collection.mutable.ArrayBuffer
import com.google.gson.annotations.Until



object CollectionExcercise {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
   /*  Removing all negative number except first
   */
   
   val buf = new ArrayBuffer[Int]                 //> buf  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
   
   buf+=(1,2,-3,4,-5,6,-7,8)                      //> res0: com.test.programs.CollectionExcercise.buf.type = ArrayBuffer(1, 2, -3,
                                                  //|  4, -5, 6, -7, 8)
 
 val toremove=	for(ele<-0 until buf.length if buf(ele)<0) yield ele
                                                  //> toremove  : scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6)
 val indextoremove=  toremove.drop(1)             //> indextoremove  : scala.collection.immutable.IndexedSeq[Int] = Vector(4, 6)
   
  // One way change original array
   for(ele<-indextoremove.reverse) buf.remove(ele)
   
   buf                                            //> res1: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, -3, 4, 6
                                                  //| , 8)
 // 2nd way (keep original array and have new result in different array
 
 for(elem<-0 until buf.length if !indextoremove.contains(elem) ) yield buf(elem)
                                                  //> res2: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, -3, 4, 8)
   
}