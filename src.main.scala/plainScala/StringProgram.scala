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

  def longdtring(s:String):Int={

    if(s.length<=1) return s.length

    var max=1
    var ptr=0

    for(i <- 1 until s.length ){

      val index=s.indexOf(s.charAt(i),ptr)
      if(index<i) ptr=index+1

      max=Math.max(max,i-ptr+1)

    }
    max
  }

  println(longdtring("dvdf"))
  def lengthOfLongestSubstring(s: String): Int = {
    var maxLen = 0
    /* Define a map where key is the character and element is index */
    /* This way we can update the index to where a character is repeated */
    var chars: Map[Char,Int] = Map.empty
    // Start of the window
    var start = 0

    for (i <- 0 until s.length){
      if (chars contains s(i)){
        /* If character is repeated, move start to one ahead of repeated character. */
        /* Take max to make sure we dont go backwards: */
        start = math.max(chars(s(i)) + 1,start)
      }
      chars += (s(i) -> i)
      maxLen = math.max(i - start + 1, maxLen)
    }
    maxLen
  }

}
