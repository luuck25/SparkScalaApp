package com.assignment.xebia.spark_app

import java.io._

object GenerateDoubles {
  
  /*                           
   *    Method to generate n double type numbers                                                   
   */
  def genDoubles(n : Int,path:String)
  {
    val r = scala.util.Random
    
    val pw = new PrintWriter(new File(path))
    
    for (i <- 1 to n)
    {
      if(i<n)
      {
      pw.write(r.nextDouble().toString())
      pw.write("\r\n")
      }
      else
      {
        pw.write(r.nextDouble().toString())
      }
    }
    
    pw.close()
  }
  
   def main(args : Array[String])
  {
    genDoubles(50000, "F:\\doubledata.txt")
    
  }
 
 
}