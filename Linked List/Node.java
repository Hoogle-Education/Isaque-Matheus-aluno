// This is going to represent the Node in the linkedlist

public class Node{
  Car car;
  Node next;

  public Node(Car car, Node next){
    this.car = car;
    this.next = next;
  }

  public Node(Car car){
    this.car = car;
  }

  @Override
  public String toString(){
    return car.toString();
  }
}
