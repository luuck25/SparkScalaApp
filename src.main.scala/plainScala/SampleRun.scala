package plainScala

object SampleRun extends  App{

  val a=readLine()

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

