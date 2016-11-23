class IyteMutableSet {
 var hashMapOfSet : IyteHashMap = new IyteHashMap ()
 
 private def contains(x : Int) : Boolean = {
   if(hashMapOfSet.get(x.toString) != false) true
   else false
 }
 
 def add(x : Int) : IyteMutableSet = {
   if(!contains(x)){
     hashMapOfSet.put(x.toString, true)
   }
   this
 }
 
override def toString () : String = {
  hashMapOfSet.toString()
}

}
object IyteMutableSet{
  def apply() : IyteMutableSet = new IyteMutableSet()
}
