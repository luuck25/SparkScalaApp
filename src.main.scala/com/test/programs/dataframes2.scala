package com.test.programs

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StructType, StructField}
import org.apache.spark.sql.catalyst.expressions.aggregate.Sum
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.catalyst.expressions.Rank
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.catalyst._
import org.apache.spark.sql.{DataFrame, Column}
import org.apache.spark.sql.types.{StructType, StructField,ArrayType,DataType}
import org.apache.spark.sql.{functions => f}
import scala.util.Try

object dataframes2 {
  
    def dropSubColumn(col: Column, colType: DataType, fullColName: String, dropColName: String): Option[Column] = {
    if (fullColName.equals(dropColName)) {
      None
    } else if (dropColName.startsWith(s"$fullColName.")) {
      
      println(colType)
      colType match {
        case colType: StructType =>
          Some(struct(
            colType.fields
              .flatMap(f =>
                dropSubColumn(col.getField(f.name), f.dataType, s"$fullColName.${f.name}", dropColName) match {
                  case Some(x) => Some(x.alias(f.name))
                  case None => None
                })
              : _*))
        case colType: ArrayType =>
          colType.elementType match {
            case innerType: StructType =>
              Some(struct(innerType.fields
                .flatMap(f =>
                  dropSubColumn(col.getField(f.name), f.dataType, s"$fullColName.${f.name}", dropColName) match {
                    case Some(x) => Some(x.alias(f.name))
                    case None => None
                  })
                : _*))
          }

        case other => Some(col)
      }
    } else {
      Some(col)
    }
  }

   def dropColumn(df: DataFrame, colName: String): DataFrame = {
  val a= df.schema.fields
      .flatMap(f => {
        println(f.dataType)
        if (colName.startsWith(s"${f.name}.")) {
          dropSubColumn(col(f.name), f.dataType, f.name, colName) match {
            case Some(x) => Some((f.name, x))
            case None => None
          }
        } else {
          None
        }
      })
  a.foreach(println)
     df.schema.fields
      .flatMap(f => {
        println(f.dataType)
        if (colName.startsWith(s"${f.name}.")) {
          dropSubColumn(col(f.name), f.dataType, f.name, colName) match {
            case Some(x) => Some((f.name, x))
            case None => None
          }
        } else {
          None
        }
      })
      .foldLeft(df.drop(colName)) {
        case (df, (colName, column)) => df.withColumn(colName, column)
      }
  }
  
   case class Address(city:String, state:String)

case class AddressWithoutZip(city:String)

val zipRm= udf { subjects: Seq[Row] => subjects.map(x=>AddressWithoutZip(x.getAs[String](0))) }
   

def zipRemove(in:Array[Address]) : Array[AddressWithoutZip] = {
        in.map{a=> AddressWithoutZip(a.city)}
  }



//val zipRm = udf(zipRemove _)


  
  
  def dfoperation()
  {
     val spark =  SparkSession.builder().appName("test word count").master("local").getOrCreate().sqlContext
   
spark.sparkContext.setLogLevel("ERROR")
   import spark.implicits._
   
   val someDF = Seq((8, "bat","bat1"),  (8, "mouse","mouse1")).toDF("number", "city","state")
  // someDF.show()
   
   val df = someDF.groupBy("number").agg(collect_list(struct("city", "state"))).as("generate")
   
 val df1=  df.withColumnRenamed("collect_list(named_struct(NamePlaceholder(), city, NamePlaceholder(), state))", "generate")
//   df1.printSchema()
   
//val a=   df1.schema.fields.filter(_.name == "generate").head.dataType.asInstanceOf[StructType]
     
  // DFWithDropFrom(df1).dropFrom("generate", Array("word")).show
  // df1.printSchema()
 //  dropColumn(df1, "generate.city").show(false)
 df1.select(zipRm(col("generate")).as("addresses_zipremoved")).printSchema()
 /*  
   someDF.schema.foreach(print)
   
 val rd=  someDF.rdd.map(x=>(x.getInt(0),List(x.getString(1),x.getString(2))))
   
 rd.foreach(println)
 
val a= rd.reduceByKey(_:::_)

import org.apache.spark.sql.types._
val addressesSchema = new StructType()
  .add($"city".string)
  .add($"state".string)
  
  val schema = new StructType()
  .add($"firstName".string)
 
  .add($"addresses".array(addressesSchema))

val d=a.map(z=> (z._1,z._2.toArray))

val dd= spark.createDataFrame(d,schema) */
   
 //  val row = Row(1,"abc")

   
  
   
  }
  
  
  

   def main(args:Array[String])
  {
 
     
    dfoperation()
  
  }
}