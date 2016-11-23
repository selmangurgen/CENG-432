class IyteImmutableSet {
 var hashMapOfSet : IyteHashMap = new IyteHashMap()
 

 def this(x: Int){
   this()
   hashMapOfSet .put(x.toString, true)
 }

 private def contains(x : Int) : Boolean = {
   if(hashMapOfSet.get(x.toString) != false) true
   else false
 }
 
 def add(number : Int) : IyteImmutableSet = {
  if(!contains(number)) new IyteImmutableSet(number)
  else null
 }
 
override def toString () : String = {
  hashMapOfSet.toString()
}

}
object IyteImmutableSet{
  def apply() : IyteImmutableSet = new IyteImmutableSet()
}