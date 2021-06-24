package com.test.programs

import org.apache.spark.sql.SparkSession

object distinctwordcount {
  
  case class sch(na : String,org:Int)
  
  def main(args:Array[String])
  {
    
    val sc =  SparkSession.builder().appName("test word count").master("local").getOrCreate().sparkContext
    
    
    val lines = sc.textFile("C:\\Users\\lucky\\Desktop\\SparkTest\\a.txt")
    
    val words = lines.flatMap(line => line.split(" ")).map(word=>(word,1))
    
    val d =words.reduceByKey(_+_)
    
    val d1=d.filter(p=>p._2==1)
    
//    val ds= d.map(p=>sch(p._1,p._2))
    
// val ds1=ds.filter(a=>a.org==1)
 
 d1.foreach(println)
    
  }
  
  
}