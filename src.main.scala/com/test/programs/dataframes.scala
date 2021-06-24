package com.test.programs

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.expressions.aggregate.Sum
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.catalyst.expressions.Rank
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.catalyst._

object dataframes {
  
  
  case class test(num:String,letter:Int)
  
  
  def readfile()
  {
    
    val sc = SparkSession.builder().appName("Read file").master("local").getOrCreate()
    
   
    
   val schema = StructType(List( StructField("num", StringType, true), StructField("letter", IntegerType, true)))
  
   import sc.implicits._
    
   // DataFrame
   
    val ab = sc.sqlContext.read.format("csv").schema(schema)load("D:\\Data\\a.txt")
   
    // DataSet
     val ab1= sc.sqlContext.read.csv("D:\\Data\\a.txt").as[test]
    
  //  ab1.select("a").show
    
    
    ab.filter('num==="Andy").show()  
    ab.show()
   //  ab.distinct().show()
    
  val a= ab.select("num").distinct().count()
   print(a)
  }
  
  
  
  
  def dfoperation()
  {
     val spark =  SparkSession.builder().appName("test word count").master("local").getOrCreate().sqlContext
   
   import spark.implicits._
   
   val someDF = Seq((8, "bat"),  (64, "mouse"),  (-27, "horse")).toDF("number", "word")
   someDF.show()
   
   someDF.schema.foreach(print)
   
   import java.sql.Date
   
   var DF = Seq((Date.valueOf("2016-09-30"), "bat"),  (Date.valueOf("2016-09-30"), "mouse"),  (Date.valueOf("2016-09-30"), "horse")).toDF("number", "word")
   
   // dd/mm/yyyy
   
   DF.schema.foreach(print)
   
   
   print("*************************")
  
   
   // DF.schema.fields.
   
   val columns=DF.schema.fields.filter(x=>x.dataType == DateType)
   
   for(coll<-columns)
   {
     
      DF=  DF.withColumn(coll.name, date_format(col(coll.name), "MM/dd/yyyy"))
      
      
   }
   
   
   
 // columns.map(x=> DF.withColumn(x.name, date_format(col(x.name), "MM/dd/yyyy")))
  
 // DF=  DF.withColumn("number", date_format(col("number"), "MM/dd/yyyy"))
 DF.show()
  
   
   
 //  DF.withColumn(columns.map(x=>x.name):_*,date_format(col("endDate"), "MM/dd/yyyy"))
   
 val ab=  DF.withColumn("word", substring(col("word"),0,4)).show()
   
   
   
   
   val someDF1 = Seq((27, "horse"),(8, "bat"),  (64, "mouse")).toDF("number", "word")
   
   someDF.select("word", "number").show()
   someDF.withColumn("new", when(someDF("number") === "27",1).otherwise(0)).show()
   
   
 //  someDF1.show()
  //  someDF.except(someDF1).show()
   
 //  someDF.groupBy().max("number").show()
   
   
 //  val columns = someDF.schema.fields.map(a=>a.name)
   
 //  val seldiff = columns.map(col=>someDF.select(col).except(someDF1.select(col)))
   
  // seldiff.map(diff => {if(diff.count > 0) diff.show})
    
   
  // val joined = someDF.join(someDF1, someDF.col("number")===someDF1.col("number"),"inner")
   // joined.show()
    
  }
  
  def analyticsl()
  {
     val spark =  SparkSession.builder().appName("test word count").master("local").getOrCreate().sqlContext
   
   import spark.implicits._
    
    val dataset = Seq(  ("Thin",       "cell phone", 6000),  ("Normal",     "tablet",     1500), ("Mini",       "tablet",     5500),
  ("Ultra thin", "cell phone", 5000),  ("Very thin",  "cell phone", 6000),  ("Big",        "tablet",     2500),
  ("Bendable",   "cell phone", 3000),  ("Foldable",   "cell phone", 3000),  ("Pro",        "tablet",     4500),
  ("Pro2",       "tablet",     6500))  .toDF("product", "category", "revenue")
    
  
  dataset.show()
  
  dataset.filter('category === "tablet").show

  val overcat = Window.partitionBy('category).orderBy('revenue.desc)
  
  val a = dataset.withColumn("rank", dense_rank().over(overcat))
  
  a.show()
  
  val b=a.filter('rank===1)
  
  b.show()
//  b.groupBy().sum("revenue").show*/
  // or
 // b.agg("revenue"->"sum").show()
  
    
  }
  
  

  /* def strLength(input: Int): String = input match {
    
    case 1  => "Pass"
    case 0  => "Fail"

  //  case _  => "Invalild"  // the default, catch-all
}
    
 def udfScoreToCategory=udf((score: Int) => {
        score match {
     case 1  => "Pass"
    case 0  => "Fail"  
       case _ => "D" 
         }})
  */
// import org.apache.spark.sql.functions.udf
  
  def udfimplement()
  {
   
   val spark =  SparkSession.builder().appName("test word count").master("local").getOrCreate().sqlContext
   
   import spark.implicits._
   
   val someDF = Seq((1, "bat"),  (0, "mouse"),  (5, "horse")).toDF("number", "word")
   
  // val accum = spark.sparkContext.accumulator(0)
   
   someDF.foreach{
     row=> row.toSeq.foreach(
         col => println(col))}
   
  // val strLengthUdf = udf(strLength _)
   
 //  spark.udf.register("strLengthUdf",strLength)
   
 //  someDF.withColumn("newcol",udfScoreToCategory(col("number")))
   
 //  someDF.show()
       
       
  }
 
   def main(args:Array[String])
  {
 
     
     udfimplement()
   
  
  }
}