package com.test.programs
import org.apache.spark.sql.SparkSession
import scala.annotation.tailrec  
    
import org.apache.spark.sql.catalyst.expressions.aggregate.Sum
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.catalyst.expressions.Rank
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.types.StructField
object scalaprocessing {

  def main(args: Array[String]) {

    readfile()
  }

  
 
  def readfile() {

    val sc = SparkSession.builder().appName("Read file").master("local").getOrCreate()

    val rdd = sc.sparkContext.parallelize(Seq("Roses are red", "Violets are blue"))

    val rdd1 = rdd.map(_.split(" "))

    rdd1.foreach(a => print(a.toSeq.toString()))

  }
}