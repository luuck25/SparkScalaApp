package SparkGeneral

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.explode

object DataBricksAssignment {

  def main(args: Array[String]) {

    readfile()
  }


  def readfile() {

    val sc = SparkSession.builder().appName("Read file").master("local").getOrCreate()
    sc.sparkContext.setLogLevel("ERROR")

    val rdd = sc.sparkContext.parallelize(Seq("Row-Key-001, K1, 10, A2, 20, K3, 30, B4, 42, K5, 19, C20, 20"))

    //  rdd.collect.foreach(println)

    import sc.sqlContext.implicits._

    val df = rdd.map(x => (x.split(',')(0), x.split(','))).toDF("a", "b")

    val df1 = df.withColumn("exp", explode(df.col("b"))).drop("b")

    df1.createOrReplaceTempView("abc")

    sc.sql("select * from abc where trim(exp) rlike '[A-Z][0-9]'  ").show()


    //  val rdd1 = rdd.map(_.split(" "))

    // rdd1.foreach(a => print(a.toSeq.toString()))

  }
}
