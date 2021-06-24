package com.test.programs

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.Row

object SQLInterview extends  App {

  val sc = SparkSession.builder().appName("Read file").master("local").getOrCreate()
  sc.sparkContext.setLogLevel("ERROR")
  val data=List(Row(1,"a","hr"),Row(2,"b","it"),Row(3,"c","hr"),Row(4,"d","hr"),Row(5,"e","it"))
  val columns=StructType(List(
    StructField("id",IntegerType,true),
    StructField("name",StringType,true),
    StructField("dept",StringType,true)
  ))
  import scala.collection.JavaConversions._
  val df= sc.createDataFrame(data,columns)
  df.createOrReplaceTempView("emp")

  //**

  //id	name	dept
  //1	a	hr
  //2	b	it
  //3	c	hr
  //4	d	hr
  //5	e	it
  // id	name	dept	count of emp dept wise
  //1	a	hr	3
  //2	b	it	2
  //3	c	hr	3
  //4	d	hr	3
  //5	e	it	2
  //
  // */
  sc.sql("select id,name,dept, count(dept) over (partition by dept) as countdeptwise from emp").show()

}
