package com.test.programs

object CollectionMap {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // By default it creates immutable Maps
   val Maps=Map(1->"a",2->"b",3->"c")             //> Maps  : scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -
                                                  //| > c)
   // to create Mutuable Maps
   
   val mutMap = scala.collection.mutable.Map(1->"MutMap")
                                                  //> mutMap  : scala.collection.mutable.Map[Int,String] = Map(1 -> MutMap)
  // Access elements
  
  
  mutMap(1)                                       //> res0: String = MutMap
  
  // if element not there instead of getting exception use Getor else to show some value
  
  mutMap.getOrElse(3, "Not There")                //> res1: String = Not There
  // change value
  
  mutMap(1)="ChangedMap"
	mutMap                                    //> res2: scala.collection.mutable.Map[Int,String] = Map(1 -> ChangedMap)

// add or remove

mutMap+=2->"Second"                               //> res3: com.test.programs.CollectionMap.mutMap.type = Map(2 -> Second, 1 -> Ch
                                                  //| angedMap)

mutMap-=2                                         //> res4: com.test.programs.CollectionMap.mutMap.type = Map(1 -> ChangedMap)

mutMap                                            //> res5: scala.collection.mutable.Map[Int,String] = Map(1 -> ChangedMap)

// Iterate of Maps

for((k,v)<-mutMap) println(k+" "+v)               //> 1 ChangedMap

// use for yield to get new map

for((k,v)<-mutMap) yield (v,k)                    //> res6: scala.collection.mutable.Map[String,Int] = Map(ChangedMap -> 1)


// use keyset and values to get only keys or values


// Tuples

val t = (1,"Lakesh",9.0)                          //> t  : (Int, String, Double) = (1,Lakesh,9.0)

t._1                                              //> res7: Int = 1
t._2                                              //> res8: String = Lakesh

}