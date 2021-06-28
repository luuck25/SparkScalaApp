package plainScala

object StringProgram extends App {

  def lengthOfLastWord(s: String): Int = {
    var count = 0;
    var len: Int = s.length - 1
    println("length is " + len)
    var nospacesize = 0
    while (len != (-1) && s.charAt(len) == ' ') len -= 1
    if (len == (-1)) return count
    nospacesize = s.length - 1 - len
    println("nospacesize is" + nospacesize)
    while (count != (s.length() - nospacesize) && s.charAt(len) != ' ') {
      count += 1
      len -= 1
    }

    count
  }

  // println(lengthOfLastWord("abc lakesh    "))


  def alternateuppercase(s: String) = {
    val name = "lakesh"
    var name1: String = ""

    for (w <- 0 to name.length - 1) {
      if (w % 2 == 0) name1 = name1 + name.charAt(w).toUpper
      else name1 = name1 + name.charAt(w)

    }

    println(name1)
  }

  def isPalindrome(s: String): Boolean = {
    var ss = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase

    for (i <- 0 to ss.length / 2) {
      println("ss " + s.charAt(i))

      if (ss.charAt(i) != ss.charAt(ss.length - 1 - i)) {
        return false
      }


    }

    return true
  }

  def isPalindrome1(s: String): Boolean = {
    println(" " + s + s.length)
    if (s.length < 2) true
    else if (!s.head.isLetterOrDigit) isPalindrome1(s.drop(1))
    else if (!s.last.isLetterOrDigit) isPalindrome1(s.dropRight(1))
    else s.head.toLower == s.last.toLower && isPalindrome1(s.drop(1).dropRight(1))
  }

  println(isPalindrome1("race a car"))

}
