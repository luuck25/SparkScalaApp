package com.test.programs

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object RDD {
  
  
   def main(args:Array[String])
  {
    
    val sc =  SparkSession.builder().appName("test word count").master("local").getOrCreate()
    
    
    val file = sc.sqlContext.read.format("csv").option("header", "true").option("inferSchema", "true")
    .load("D:\\Data\\SFFoodProgram_Complete_Data\\sample.txt")
    
    val filen = sc.sqlContext.read.format("csv").option("header", "true").option("inferSchema", "true")
    .load("D:\\Data\\SFFoodProgram_Complete_Data\\sample.txt")
    
    file.cache()
    
    import sc.implicits._
    
    
    val joined = file.join(filen, file("business_id")===filen("business_id") and  file("business_id")===filen("business_id"), "inner").show()
   
  //  file.select("Score","type").show()
    
 //   val file1 =   file.groupBy("type").sum("business_id").alias("sum").show()
 
  // file1.withColumnRenamed("sum(business_id)", "sum")
    
  // file1.filter('type === "Routine - Unscheduled").show()
    
    
    val lines = sc.sparkContext.textFile("D:\\Data\\SFFoodProgram_Complete_Data\\sample.txt")
    
   // lines.foreach(println)
  }
   
}