/*
  We would like to create an object that is going to encapsulate a Car and we
  will use this in our Node class for the linked list.
*/
public class Car{
  // instance variables are going to describe the details of the object
/*
  Car Registration Details, Owners Name,
  Problem Description, Cost of Fixing the Problem,
  Car status (if the car is ready to be collected).
*/

  public String reg;
  public String name;
  public String contactNum;
  public String problem;
  public boolean status;
  public int cost;

  public Car(String reg, String name, String contactNum, String problem){
    /*
        We get to decide what we do with the variables when an object of
        type car is created...
    */
    this.reg = reg;
    this.name = name;
    this.contactNum = contactNum;
    this.problem = problem;
    this.status = false;
    this.cost = 0;
  }

  @Override
  public String toString(){
    /*
      We would like java to print out the car details in the following format

      Car Details
      Registration: 19-D-21
      Owners Name: “Keith Maycock”
      Contact Number: 08X 8736271
      Problem Description: “The car only had 3 wheels” Cost of Fixing the Problem: €100
      Car Status: “Ready for Collection”
  */
    String output = "Car Details\n";
    output += "Registration: "+this.reg+"\n";
    output += "Owners Name: "+this.name+"\n";
    output += "Contact Number: "+this.contactNum+"\n";
    output += "Problem Description: "+this.problem+"\n";
    output += "Cost of Fixing the Problem: "+this.cost+"\n";
    String carStat = "";
    if(this.status){
      carStat = "Ready for Collection";
    }else{
      carStat = "Not Ready for Collection";
    }
    output += "Car Status: "+carStat;

    return output;
  }

//this method is used to change the status of the car
  public void setStatus(boolean ready){
    this.status = ready;
  }

//This method is used to set the price of fixing the car
  public void setPrice(int cost){
    this.cost = cost;
  }

  public static void main(String [] args){
    Car car1 = new Car("161-D-126", "Keith", "087 12121234", "The car has no engine");
    System.out.println(car1);
  }


}
