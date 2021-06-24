 package com.test.programs

import org.apache.spark.sql.SparkSession

object countocc {
  
  
  def main(args:Array[String])
  {
  
   val sc =  SparkSession.builder().appName("test word count").master("local").getOrCreate()
    
   
    import sc.implicits._
    
    val lines = sc.sparkContext.textFile("C:\\Users\\lucky\\Desktop\\Sparktest\\a.txt")
    
   // lines.toDF("line").show()
   
    
    val linee = lines.map(line => line.split("")).map(char=>(char,1)).reduceByKey(_+_).collect()
    
   
  
    

   
  }
  
}