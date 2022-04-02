// This is going to be the class for our linked list


/*

7. remove - this method removes the first occurrence of the target Node. The target is defined
  by Car Registration
*/
public class LinkedList{
  private Node first;
  private Node last;

/*
    our second method for remove needs to identify the index of the car based on the reg number
*/
public void remove(String target){
  Node current = first;
  int index = 0;
  while(current !=null && !current.car.reg.equals(target)){
    current = current.next;
    index++;
  }
  if(current != null && current.car.reg.equals(target)){
    remove(index);
  }
}

/*
  remove - this method removes the first occurrence of the target Node. The target is defined
  by Car Registration
*/
public void remove(int index){
  if(index < 0 || index >=size()){
    throw new IndexOutOfBoundsException();
  }
  if(index == 0){
    first = first.next;
    if(first == null){
      last = null;
    }
  }else{
    Node pred = first;
    for(int k =1;k <=index-1;k++){
      pred = pred.next;
    }
    pred.next = pred.next.next;
    if(pred.next == null){
      last = pred;
    }
  }
}

/*
  add - this method should allow the addition of a new Node into the linkedlist at the end of
  the current list
*/
public void add(Car elem){
  if(isEmpty()){
    Node insertion = new Node(elem);
    first = insertion;
    last = first;
  }else{
    last.next = new Node(elem);
    last = last.next;
  }
}

/*
  get_average – this method should return the average cost of fixing cars based on the current
  LinkedList
*/
public double get_average(){
  double avg_cost = 0.0;
  int counter = 0;
  Node current = first;
  while(current != null){
    //the condition will check if the price has been added to the car object
    if(current.car.cost !=0){
      avg_cost += current.car.cost;
      counter++;
    }
    current = current.next;
  }
  avg_cost = avg_cost / counter;
  return avg_cost;
}


/*
  currentProblems - this method should return the a String representation of the cars within
  the Linkedlist that are not ready for collection
*/
public String currentProblems(){
  String output = "The following cars are not ready for collection \n";
  Node current = first;
  while(current != null){
    //we need a condition to identify if a car is not ready for collection
    if(!current.car.status){
      output += current.car.reg+"\n";
    }
    current = current.next;
  }
  return output;
}

/*
  readySize – this method should return the number of cars within the Linkedlist that are ready
  for collection
  This sounds like the size method with an added condition
*/
public int readySize(){
  int size = 0;
  Node current = first;
  while(current != null){
    //we need a condition to identify if a car is ready for collection
    if(current.car.status){
      size++;
    }
    current = current.next;
  }
  return size;
}


@Override
public String toString(){
  String rep = "Garage Cars\n";
  Node current = first;
  while(current!=null){
    rep += current.toString() + "\n";
    current = current.next;
  }
  rep += "-------------------------------\n";
  return rep;
}

  /*
      The folllowing method size counts the number of objects in the linkedlist
  */
  public int size(){
    int size = 0;
    Node current = first;
    while(current != null){
      size++;
      current = current.next;
    }
    return size;
  }



/*
  isEmpty – this method should check if the linkedlist is empty and return a Boolean
*/
  public boolean isEmpty(){
    return first == null;
  }
}
