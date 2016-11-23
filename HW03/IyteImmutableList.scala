class IyteImmutableList {
  var immutablelist = new Array[Int](0);

  def add(element: Int): IyteImmutableList = {
    val im = new IyteImmutableList(); // create a new instance of IyteImmutable class in order not to mutate the list
    val temp = Array(element);
    im.immutablelist = Array.concat(immutablelist,temp );  // temprorily adds a element to the list
    im;
  }

  override def toString(): String = {
    immutablelist.mkString(",");
  }
}

object IyteImmutableList {
  def apply() = new IyteImmutableList;
}