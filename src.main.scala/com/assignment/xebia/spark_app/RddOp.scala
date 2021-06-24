package com.assignment.xebia.spark_app

import org.apache.spark.sql._

import org.apache.spark.sql.types._


object RddOp {
  
 /* Method which is called from main and calculates average of doubles and sum of 
  * converted int values using RDD 
  */
  
  def RddOp()
  {
    val spark = SparkSession.builder().appName("assignment").master("local").getOrCreate().sparkContext
    val input =  spark.textFile("F:\\doubledata.txt")
    val numbers = input.map(_.toDouble)
    
    println("Average is "+numbers.mean())
      
    val numbersint = numbers.map(_.toInt)
    
    println("Sum is "+numbersint.sum())
    
  }
  
  /* Method which is called from main and calculates average of doubles and sum of 
  * converted int values using DataFrames 
  */

  def dfoperation()
  {
     val spark = SparkSession.builder().appName("assignment").master("local").getOrCreate().sqlContext
     val schema = StructType(StructField("num", DoubleType, true) :: Nil)
     val df = spark.read.schema(schema).csv("F:\\doubledata.txt")
     df.createOrReplaceTempView("temp")
     
     spark.sql("select avg(num) from temp").show()
     
    
     val newDF = df.select(df.columns.map(c => df.col(c).cast("integer")): _*)
     newDF.createOrReplaceTempView("temp1")
     spark.sql("select sum(num) from temp1").show()
   
     // Create Sample 100 Records DataFrame
       
    val sampledf = df.sample(true, .002).limit(100)
    println("count is "+sampledf.count())
    sampledf.show()
    
  }
  
  def main(args : Array[String])
  {
   RddOp()
   dfoperation()
   
  }
}