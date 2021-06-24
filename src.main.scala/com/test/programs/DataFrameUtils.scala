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

object DataFrameUtils {

   def dropSubColumn(col: Column, colType: DataType, fullColName: String, dropColName: String): Option[Column] = {
    if (fullColName.equals(dropColName)) {
      None
    } else if (dropColName.startsWith(s"$fullColName.")) {
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
    df.schema.fields
      .flatMap(f => {
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

  /**
    * Extended version of DataFrame that allows to operate on nested fields
    */
/*  implicit class ExtendedDataFrame(df: DataFrame) extends Serializable {
    
	   def dropNestedColumn(colName: String): DataFrame = {
      DataFrameUtils.dropColumn(df, colName)
    }
  } */

}