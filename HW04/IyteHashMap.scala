class IyteHashMap {  // Mutable HashMap
  private val SIZE : Int = 128 // number of elements in the hashmap
  var items : Array[IyteHashMapItem] = new Array[IyteHashMapItem](SIZE)
  var result : String = null
  var count = 0
 
  
  def get(key : String ) : Boolean = {
    var hash : Int = key.hashCode() % SIZE //take hash code
    var temp : IyteHashMapItem= items(hash) 
    var result : Boolean = false
    
    while(temp != null   ){
      if(temp.key.equals(key)) result = true 
      temp = temp.nextItem 
    }
 result
  }
  
  def put(key : String , value : Boolean ) : IyteHashMap = {
    var hash : Int = key.hashCode() % SIZE //take hash code
    var temp : IyteHashMapItem= items(hash) 
    
    if(temp != null){
      if(temp.key .equals(key)) {
        temp .value = true
      }
      else{
        while(temp.nextItem != null){
           temp = temp.nextItem 
        }//end of the map
       var newItem :IyteHashMapItem = new IyteHashMapItem(key,value)
       temp.nextItem  = newItem
      }
      
    }
    else{
      var newItem :IyteHashMapItem = new IyteHashMapItem(key,value)
      items(hash) = newItem
    }
    this
  }
  
  def getItems(): Array[IyteHashMapItem] = {
    this.items 
  }
  
  override def toString() : String = { 
    var x = 0
    count = 0
    result = null
    result = "Set("
    for ( x <- items ) {
      if(x != null){
        result  = result  + x.getKey() + ","
        count = count +1
      }
     }
    result + ")"
   
  }
  
}
object IyteHashMap {
  def apply () = new IyteHashMap()
}