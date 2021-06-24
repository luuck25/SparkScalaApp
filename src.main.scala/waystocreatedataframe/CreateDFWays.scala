package waystocreatedataframe

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object CreateDFWays extends  App{

  // From RDD

  val spark:SparkSession = SparkSession.builder()
    .master("local[1]").appName("SparkByExamples.com")
    .getOrCreate()
spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._
  val columns = Seq("language","users_count")
  val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))


  val rdd= spark.sparkContext.parallelize(data)

  // 1 way

    rdd.toDF("language","users_count").show()
     rdd.toDF(columns:_*).show()

  //  2 way

  spark.createDataFrame(rdd).toDF("language","users_count").show()
  spark.createDataFrame(rdd).toDF(columns:_*)

  // 3 way Using createDataFrame() with the Row type
  /* createDataFrame() has another signature which takes the RDD[Row] type and schema for column names as arguments.
   To use this first we need to convert our “rdd” object from RDD[T] to RDD[Row] and define a schema using StructType & StructField.*/

val rowRdd=rdd.map(x=> Row(x._1,x._2))
val schema= StructType(List(StructField("language",StringType,false),
  StructField("users_count",StringType,false)
))


   spark.createDataFrame(rowRdd,schema).show()

  // Create Spark DataFrame from List and Seq Collection

  data.toDF(columns:_*).show()  // Using toDF() on List or Seq collection

  spark.createDataFrame(data).toDF(columns:_*) // Using createDataFrame() from SparkSession

  //  Using createDataFrame() with the Row type

  // createDataFrame() has another signature in Spark which takes the util.List of Row type
  // and schema for column names as arguments. To use this first we need to import scala.collection.JavaConversions._

  import scala.collection.JavaConversions._
  //From Data (USING createDataFrame and Adding schema using StructType)
  val rowData= Seq(Row("Java", "20000"),
    Row("Python", "100000"),
    Row("Scala", "3000"))
  var dfFromData3 = spark.createDataFrame(rowData,schema)

  // Create Spark DataFrame from CSV, json, text ,XML
  val df2 = spark.read.csv("/src/resources/file.csv")
  spark.read.text("/src/resources/file.txt")
  spark.read.json("/src/resources/file.json")

  // To create DataFrame by parse XML, we should use DataSource "com.databricks.spark.xml" spark-xml api from Databricks.

 /* val df = spark.read
    .format("com.databricks.spark.xml")
    .option("rowTag", "person")
    .xml("src/main/resources/persons.xml") */


  // from jdbc

//  val df_mysql = spark.read.format("jdbc")
//    .option("url, "jdbc")
//    .option("driver", "com.mysql.jdbc.Driver")
//    .option("dbtable", "tablename")
//    .option("user", "user")
//    .option("password", "password")
//    .load()

  //  Create DataFrame from HBase table

  // To create Spark DataFrame from the HBase table, we should use DataSource defined in Spark HBase connectors. for example use DataSource “org.apache.spark.sql.execution.datasources.hbase”
  // from Hortonworks or use “org.apache.hadoop.hbase.spark” from spark HBase connector.

  /*val hbaseDF = sparkSession.read
    .options(Map(HBaseTableCatalog.tableCatalog -> catalog))
    .format("org.apache.spark.sql.execution.datasources.hbase")
    .load()*/

}
