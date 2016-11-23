class IyteHashMapItem {
  var key : String = null
  var value : Boolean = false
  var nextItem : IyteHashMapItem = null
  
  def this(key : String , value : Boolean ){
    this()
    this.key  = key
    this.value = value
  }
  def this(key : String , value : Boolean  , nextItem : IyteHashMapItem){
    this(key  , value )
    this.nextItem = nextItem
  }
  
   def getKey(): String = {
    this.key;
   }

  def setKey(key: String): Unit = {
    this.key = key;
  }

 def getValue(): Boolean  = {
   this.value 
 }
 
 def setValue (value : Boolean ) : Unit  = {
   this.value = value
 }
 
 override def toString() : String = {
   var result = "";
   result = "[Value = ]" + getKey
   result
 }

}