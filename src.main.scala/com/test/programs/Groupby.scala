package com.test.programs


import org.apache.spark.sql._
import org.apache.spark.sql.SparkSession


object Groupby {
  
   case class sch(na : String,org:String,sal:String)
   
   
  def main(args:Array[String])
  {
    
    
    val sc =  SparkSession.builder().appName("test word count").master("local").getOrCreate()
    
   
    import sc.implicits._
    
    val lines = sc.sparkContext.textFile("C:\\Users\\lucky\\Desktop\\Sparktest\\b.txt")
   
    
    val linee = lines.map(line => line.split(",")).map(p=>sch(p(0).toString(),p(1).toString(),p(2).toString())).groupBy(c=>c.org)
    
    linee.foreach(print)
    
    val df = linee.toDF()
    
    df.show()
    
    df.groupBy($"org").count().show()   
    
    
  }
  
  
  
}