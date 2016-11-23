

class IyteMutableList {
  private class Node(var data:Int, var next: Node)
  private var head: Node = null
  private var last: Node = null
  
  def add( data: Int): Unit ={
    if(head==null){
      head= new Node(data,head)
      last=head
    }else{
      last.next=new Node(data,null)
      last=last.next

    }
  }
  override def toString: String= {
    var result:String = ""
    var rover = head
    while(rover.next !=null){
      result=result+rover.data+","
      
      rover=rover.next
    }
      result=result+last.data
      result
  }
}
object  IyteMutableList{
  def apply(): IyteMutableList = new IyteMutableList()
}