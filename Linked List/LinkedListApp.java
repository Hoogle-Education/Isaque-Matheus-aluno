public class LinkedListApp{
  public static void main(String [] args){
    Car car1 = new Car("161-D-178", "Keith", "087 12121234", "The car has no engine");
    Car car2 = new Car("171-D-176", "Jack", "087 12121234", "The car has no engine");
    Car car3 = new Car("181-D-145", "Bob", "087 12121234", "The car has no engine");
    Car car4 = new Car("191-D-123", "Sarah", "087 12121234", "The car has no engine");
    Car car5 = new Car("151-D-123", "Jane", "087 12121234", "The car has no engine");

    car1.setStatus(true);
    car1.setPrice(100);

    LinkedList mylist = new LinkedList();
    mylist.add(car1);
    mylist.add(car2);
    mylist.add(car3);
    mylist.add(car4);
    mylist.add(car5);
    car2.setStatus(true);
    car2.setPrice(50);

    //System.out.println(mylist);
    Sy 
    System.out.println(mylist.currentProblems());

  }
}
