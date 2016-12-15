class IyteHashTable(var items:Array[Item],var itemSize:Int,var itemCount:Int){

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

    def get(key:String):String={
   try{
     var getIndex=getHashCode(key)					
     
     while(items(getIndex).key != key && getIndex < itemSize){	
       getIndex=getIndex+1
       if(getIndex==itemSize){
       getIndex=0
       }
     }
     items(getIndex).value		
   }
   catch{
    case c: Exception => return null	
   }
 }  
   
  def set(key:String, value:String){
     val x=itemCount.toFloat / itemSize
     if(x > 0.65){										
       val tempitemSize=itemSize*2
       var tempitems = new Array[Item](tempitemSize)  
       for(i<-0 to (itemSize-1) ){
         tempitems(i)=items(i)
       }
       itemSize=tempitemSize
       items=tempitems
     }
	   val item = new Item(key,value)					
	   var addedIndex=getHashCode(key)				
	   while(items(addedIndex) != null && addedIndex < itemSize){		
	     if(items(addedIndex).key == key){		
	       println("Key is already used")
	       return
	     }  
	     addedIndex=addedIndex+1
			
	     if(addedIndex==itemSize){	
	       addedIndex=0
	     }
	   }
     items(addedIndex)=item
     itemCount=itemCount+1
 }  

}
object IyteHashTable{
  def apply()={
    val itemSize=10000000					
    val items=new Array[Item](itemSize)
    val itemCount=0
    new IyteHashTable(items,itemSize,itemCount)
  }
}

class Item(val keyOfItem:String,val valueOfItem:String) {	
  val key=keyOfItem
  val value=valueOfItem 
}