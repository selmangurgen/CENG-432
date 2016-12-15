class IyteHashTable(var allItems:Array[Item],var sizeOfItems:Int,var numberOfItems:Int){

   def getHashCode(key:String):Int={		
   var code=5381
   for(i<-0 to key.length()-1){
     code = ((code << 5) + code) + key.charAt(i)	
   }
   if(code<0){
     code=code*(-1)
   }
   code%10000000			
 }

  def set(key:String, value:String){
     val loadFactor=numberOfItems.toFloat / sizeOfItems
     if(loadFactor > 0.65){										
       val tempSizeOfItems=sizeOfItems*2
       var tempAllItems = new Array[Item](tempSizeOfItems)  
       for(i<-0 to (sizeOfItems-1) ){
         tempAllItems(i)=allItems(i)
       }
       sizeOfItems=tempSizeOfItems
       allItems=tempAllItems
     }
	   val item = new Item(key,value)					
	   var addedIndex=getHashCode(key)				
	   while(allItems(addedIndex) != null && addedIndex < sizeOfItems){		
	     if(allItems(addedIndex).key == key){		
	       println("Key is already used")
	       return
	     }  
	     addedIndex=addedIndex+1
			
	     if(addedIndex==sizeOfItems){	
	       addedIndex=0
	     }
	   }
     allItems(addedIndex)=item
     numberOfItems=numberOfItems+1
 }  

 def get(key:String):String={
   try{
     var getIndex=getHashCode(key)					
     
     while(allItems(getIndex).key != key && getIndex < sizeOfItems){	
       getIndex=getIndex+1
       if(getIndex==sizeOfItems){
       getIndex=0
       }
     }
     allItems(getIndex).value		
   }
   catch{
    case e: Exception => return null	
   }
 }  

}
object IyteHashTable{
  def apply()={
    val sizeOfItems=10000000					
    val allItems=new Array[Item](sizeOfItems)
    val numberOfItems=0
    new IyteHashTable(allItems,sizeOfItems,numberOfItems)
  }
}

class Item(val keyOfItem:String,val valueOfItem:String) {	
  val key=keyOfItem
  val value=valueOfItem 
}