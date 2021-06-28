package com.test.programs

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{collect_list, struct}


object tryprogram extends App {


  val spark =  SparkSession.builder().appName("test word count").master("local").getOrCreate().sqlContext
  spark.sparkContext.setLogLevel("ERROR")
val df=spark.read.format("csv").option("header", "true").option("inferSchema", "true").load("D:\\sampledatatable.csv")
 // df.show()

 val df1= df.groupBy("account")agg(collect_list(
      struct("key","createdate",
        "f_name","home_number","mobile_number")).alias("coll"))
  df1.show(false)



}
