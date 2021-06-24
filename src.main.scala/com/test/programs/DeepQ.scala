package com.test.programs
import org.apache.spark.sql.SparkSession

object DeepQ {
  
  
   def main(args:Array[String])
  {
 
     
   val spark = SparkSession.builder().appName("Read file").master("local").getOrCreate()
   
   val df= spark.read.option("header","true").csv("C:\\Users\\lucky\\Downloads\\1000-Records")
   
   df.printSchema()
   
 import scala.util.matching.Regex
import com.amazon.deequ.{VerificationSuite, VerificationResult}
import com.amazon.deequ.VerificationResult.checkResultsAsDataFrame
import com.amazon.deequ.checks.{Check, CheckLevel}
import com.amazon.deequ.constraints.ConstrainableDataTypes
val _check = Check(CheckLevel.Error, "Data Validation Check")
  .isComplete("First_Name")
  .isComplete("Month_Name_of_Joining")
  .isContainedIn("Month_Name_of_Joining", Array("August", "July", "January", "April", "December", "November", "February", "March", "June", "September", "May", "October"))
  .isComplete("Phone_No")
  .containsEmail("E_Mail")
  .containsSocialSecurityNumber("SSN")
  .isContainedIn("Day_of_Joining", 1, 31, includeLowerBound = true, includeUpperBound = true)
  .hasPattern("Phone_No", """^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$""".r)
  .hasDataType("Emp_ID", ConstrainableDataTypes.Integral)
  .isUnique("Emp_ID")
val verificationResult: VerificationResult = { VerificationSuite()
  .onData(df)
  .addCheck(_check)
  .run()
}


val resultDataFrame = checkResultsAsDataFrame(spark, verificationResult)


} }

