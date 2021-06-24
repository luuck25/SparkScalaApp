package com.test.programs

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.expressions.Concat


object wordcount {
  
  def main(args:Array[String])
  {
    
    val sc =  SparkSession.builder().appName("test word count").master("local").getOrCreate().sparkContext
       
   val lines = sc.textFile("C:\\Users\\lucky\\Desktop\\a.txt",2)
    
  /*  val words = lines.flatMap(line => line.split(" ")).map(word=>(word,1))
    
    val a = words.reduceByKey(_+_)

    a.foreach(println)*/
    
    
    val sampleList = Array("One", "Two", "Three", "Four","Five")
    val sampleRDD = sc.parallelize(sampleList, 2)
    val result = lines.mapPartitions((rows:Iterator[String]) => addRandomNumber(rows))
    
    result.foreach(println)
 
  val res = result.mapPartitions(Iterator=>{
  var result=Iterator.map(x=>
    
    if(x._2==0 && Iterator.hasNext==(false) ) 
    { 
      "["+x._1+"]"
    } 
    else if(x._2==0 )
    {
      "["+x._1+","
    }
    else if (Iterator.hasNext)
    {
       x._1+","
    }
    
 //   else if(x._2==Iterator.size+1) { 
      
  //    println(Iterator.size)
      
 //     println( x._1+"]" )
      
 //   }
    
    else { 
         x._1+"]"
      
         }
     )
    
    result
    
  })
   
   res.foreach(println) 
   
 //  res.saveAsTextFile("C:\\Users\\lucky\\Desktop\\samp")
    
 //  a.foreach(print)
    
//result.map(x=> if(x._2==0) "["+x._1+"," 
////
//else if (x._2==result.count().toInt) x._1+"]").foreach(println)
       
   /*val a= sampleRDD.mapPartitionsWithIndex((idx:Int, itr:Iterator[String]) => {
         itr.map(n => (idx, n) )          
      })*/
  //  result.foreach(println)
  //  a.foreach(println)

  }
  
  import scala.util.Random

  def addRandomNumber(rows:Iterator[String]) = {

    val rand = new Random(System.currentTimeMillis + Random.nextInt)
  
 
  rows.zipWithIndex
}
  
   def showParts(iter: Iterator[(String, Int)]) = 
{ 
    println(iter.size)
     
 // val cur = iter.next;
  val result= iter.map(cur=>cur._2)
    
 /*   if(cur._2==0)
    {
      
  "["+cur._1+","
  
    }
    else if(cur._2==iter.size)
    {
      
       cur._1+"]"
    }
    else
    {
     print(cur._2) 
    cur._1+","
    }
    
     
    // Do something with cur
   ) */
}

  // return Iterator[U]
 
}
  
