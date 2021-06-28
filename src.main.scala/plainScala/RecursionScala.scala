package plainScala

import scala.annotation.tailrec

object RecursionScala extends App {

  // 5* f(4)
  //     4*f(3)
  //       3*f(2)
  //        2*f(1)
// recursion problems
  def factorial(n: Int): Int = {

    if (n == 1) 1
    else {
      n * factorial(n - 1)
    }
  }

  def fibo(n: Int): Int = {

    if (n == 0) 0
    else if (n == 1) 1
    else fibo(n - 2) + fibo(n - 1)

  }

  def palimdrome(n: String): Boolean = {
    @tailrec
    def palim(n: String, start: Int, end: Int): Boolean = {
      if (start == end) true
      else if (n(start) != n(end)) false
      else palim(n, start + 1, end - 1)
    }

    palim(n, 0, n.length - 1)
  }


  def palimdrome1(n: String): Boolean = {
    if (n.length == 1) true
    else if (n.head == n.last) palimdrome1(n.drop(1).dropRight(1))
    else false
  }

  def sumofdigits(n:Int):Int={
    if(n==0)  0
    else sumofdigits(n/10)+n%10



  }
  println(sumofdigits(4667))
//  println(palimdrome1("MADAM"))



  //println("MADAM".drop(1).dropRight(1))
}
