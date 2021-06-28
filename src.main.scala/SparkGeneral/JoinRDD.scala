package SparkGeneral

import org.apache.spark.sql.SparkSession

case class empp(name:String,dep:Int)

case class depp(dep:Int,sal:Int)

object JoinRDD {
  
  def main(args:Array[String])
  {
  
  val sc =  SparkSession.builder().appName("test word count").master("local").getOrCreate()
  
  val emp=sc.sparkContext.parallelize(Seq(("lakesh",1),("lucky",1),("lucky",3)))
  
  val dep=sc.sparkContext.parallelize(Seq((1,4000),(3,2000)))
  
  
  val emp1=emp.map(e=>empp(e._1,e._2))
  
  val dep1=dep.map(m=>depp(m._1,m._2))
  
  val empj = emp1.map(e=>(e.dep,e))
      
  val depj=dep1.map(d=>(d.dep,d))
      
  val joined=empj.join(depj)
  
  val ab =joined.sortBy(_._2._2.sal,false).take(1)
  
  ab.foreach(println)
} }