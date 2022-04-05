class Subject{

  // these are the instance variables...every subject has a module (name) and an associated grade
  private String module;  
  private int grade;

  public Subject(String module, int grade){
    this.module = module;
    this.grade = grade;
  }

  public Subject(String module){
    this.module = module;
    this.grade = 0;
  }

  // this is a getter method that simply returns the value of the instance variable
  public int getGrade(){
    return grade;
  }

  public void setGrade(int grade){
    this.grade = grade;
  }

  public String getModule(){
    return module;
  }

  public static void main(String [] args){
    System.out.println("Started Executing");
    Subject data = new Subject("Data Structures and Algorithms", 70);
    System.out.println(data.module);
    System.out.println(data.grade);

  }
}

class Node{
  //Each Node will contain a Subject Object and a Node Object...
  // Remember that we have defined the Subject Object with the characteristics
  // to answer the question.
  Subject s;
  Node next;
  Node prev;

  // This constructor will be called when we have the subject object and a reference to the next
  // Node in the Data Structure.
  public Node(Subject s, Node n){
    this.s = s;
    this.next = n;
    n.prev = this;
  }

  // This node will be instantiated when we only have the subject object
  public Node(Subject s){
    this.s = s;
    next = null;
    prev = null;
  }

  public String toString(){
	     return "Subject: "+s.getModule()+" - Grade: "+s.getGrade()+"%";       
  }

  public static void main(String [] args){
    System.out.println("Started Executing");
    //Creating an instance of the a Node passing in a Subject Object
    Node node = new Node(new Subject("Data Structures", 70));
    //printing out the result of a call to the getModule() method for the subject
    System.out.println(node.s.getModule());
  }
}

/*
    This class represents the LinkedList that is going to be used for the Academic Record. Direct access to the first and last nodes are needed as defined by the problem. This is important to be able to traverse the Data Structure. Remember  we define this as instance variales under the class declaration.
 */

public class LinkedList {

    /*
        These are our instance variables that we are using with the class LinkedList to have
        access to the first and last Nodes within the Data Structure.
    */
    Node first, last;

    /*
        If we want to make a concrete object or instantiate a class we define a constructor. In our
        constructor for the LinkedList we are simply going to allow the creation of an empty LinkedList and we will set both the first and last Nodes to null. Then in our main method we would call:

        LinkedList myList = new LinkedList();

        This creates the the empty LinkedList and assigns the variable name myList to this LinkedList
    */
    public LinkedList() {
        first = null;
        last = null;
    }

    /*
      This method is used to be able to check if the LinkedList is empty. If we look at the method signature, we see that the method is public, it returns a Boolean (True or False) and the method is called isEmpty. We can also see that the method has no parameters. To check if a LinkedList is empty the simple logic call of first == null is suitable. Remember when we create an empty LinkedList we set first == null.

      When annotating Java documents we typically identify the paramaters and the return type like below:

      @param N/A
      @return boolean, check if the LinkedList is empty
    */
    public boolean isEmpty() {
        return (first == null);
    }

    /*
      Ths is the size method, an essential method to be able to iterate over the collection of Nodes and count each step. We are just trying to count how many objects are in the LinkedList. Remember Mario's idea of a vehical moving across the LinkedList. The idea is straight forward and for a Single LinkedList we move in one direction. We start at the first Node, because we have a reference to that Node (remember our instance variables above). We then simply need to go through the LinkedList one Node at a time and on each change to a new Node we increment our counter variable. For example,

      We need a counter variable so we define: int count = 0; => this means that we have just defined a variable, remember Java has no idea of what you are doing its not going to help, this variable is called "count", it is of type int and we have initialised it to start counting at 0.

      We need to grab a reference to the first Node in the LinkedList, this is cool as we defined an instance variable which gives us this reference point. In java we do the following:

      Node node = first; => Creating a variable of type Node that is called "node" to be the same as first

      The Loop helps us to perform something a number of times until a condition is met, this is how our vehicle moves over the collection of odjects (our LinkedList)! Using a While Loop makes most sense here.

      The condition is going to be simple, while Node is not null grab the next node and increase the counter variable by 1:

      while (node != null) { => This is the condition
          count++;// increasing the counter by 1
          node = node.next;//this is where we assign the node to be the next node in the list
      }

      As we can see above the actual movement is simple the variable node is assigned the value of the next node.

      @param N/A
      @return int, the number of Nodes in the LinkedList
    */
    public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /*
     This method returns the average of all the grades included in the linkedlist, it traverses through the list while (just like the movement above in the size method) but instead of just incrementing a counter variable by 1 it adds the result of the module within each into a variable and then divides it by the list's size, if the list is empty 0.0 is returned. This is the same stragety as before we are just changing the calculation!!

     Our LinkedList looks something like the following:

     N1 [S1, N2] -> N2 [S2, N3] -> N3[S3, N4].....NULL

     N1 is a Node and the Node consists of a Subject Object (S1) and a Node Object (N2) which is the pointer to the next Node in the LinkedList.

     NUMBER OF NODES ... we have a method called size() which returns the number of Nodes
     AVERAGE GRADE ... this should be easy if we can get access to the grade number!!! But we do need access to the grade within the module. Remember we defined the Node that contained the information about a subject(module name and grade). We also defined methods to be able to get access to these variables, for example,

     N1.s.getGrade() --> returns the value for the grade in Node N1

     Putting all this together we get the following in java:

     double sum = 0; // this is our variable that will hold the value of the sum of all the grades.
     double answer = 0.0; // we need a variable to hold the result that will be returned
     if (!isEmpty()) {//the linked list if empty return 0.0;
         Node node = first;// we start at the start of the linkedlist
         while (node != null) {//we iterate until the Node is null this is the end of the linkedlist
             sum = sum + node.s.getGrade();// node.s.getGrade is just a number
             node = node.next;// this performs the movement along the collection
         }
         answer = sum / size();// this calculates the average
     }
     return answer;
     @param N/A
     @return double, the average grade in an Academic Record
     */
    public double get_average() {
        double sum = 0;
        double answer = 0.0;
        if ( !isEmpty() ) {
            Node current = first;
            while (current != null){
                sum = sum + current.s.getGrade();
                current = current.next;
            }
            answer = sum / size();
        }
        return answer;
    }

    /*
      This method adds a Node in at the end of the LinkedList. There are only two cases to consider: the first case is when there are no elements in the LinkedList, i.e. isEmpty() returns a true or there is something in the LinkedList and the node is added in at the end...

      @param module, this should be of type Subject
      @return void, nothing is returned but the new object should nbe added into our LinkedList
    */
    public void add(Subject module){
      if (isEmpty()) {
        this.first = new Node(module);
        this.last = this.first;
      } else {
        this.last.next = new Node(module);
        this.last = this.last.next;
      }
    }

    public void addFront(Subject module){
      if (isEmpty()) {
        this.first = new Node(module);
        this.last = this.first;
      } else {
        this.first.prev = new Node(module);
        this.first = this.first.prev;
      }
    }

    /*
       This method removes an object from the LinkedList. The object to be removed is indentified by passing in the name of the module to be removed as a paramater into the method signature. We need to check if there is a Subject in the LinkedList with the name of the module being passed in. Remember we need to be able to move through the collection and at each Node check if the name of the module is found. There are a few special cases to be aware of:

       case 1: we don't find the module, then we should simply return something that tells us this, for example;

       we are going to incrememt a counter when checking if the module is in the linkedlist. After going through the full linkedlist the counter should be the same as the number of elements within the list, so all we have to do is check if the counter is the same as the size of the linkedlist and if so return "Not Found"

       if(counter == size()){
         return "Not Found";
       }

       using the size() method we can check if the node to be removed is the last node in the LinkedList, for example,

       Remember to remove a node we simply need to change the reference to the next Node in the Linkedlist.
       if (counter == size() - 1) {
           this.last = node;
           this.last.next = null;
       }

       @param target, this should be the name of a module to be removed.
       @return String, we are going to either return "Removed" or "Not Removed" depending on if we can find and remove the target module from the linkedlist
     */
    public String remove(String target){
      Node node = this.first;
      int counter = 0;

      while (node.next != null){
        if ( !node.s.getModule().equalsIgnoreCase(target) ) {
          counter++;
          node = node.next;
        }else{
          break;
        }
      }

      if(counter == size()){
        return "Not Found";
      } else {
        node = this.first;
        counter = 1;
        if(this.first.s.getModule().equalsIgnoreCase(target)) {
          this.first = first.next;
        }else{
          while(!node.next.s.getModule().equalsIgnoreCase(target)) {
            counter++;
            node = node.next;
          }
          if (counter == size() - 1) {
            this.last = node;
            this.last.next = null;
          }else{
            node.next = node.next.next;
          }
        }
      }
      return "Removed";
    }

    /*
        Traverses through the list forming a string with the list's elements,
        if the list is empty another message is returned

        @param N/A
        @return String, we are going to return a string representation of the LinkedList
     */
    public String printList(){
      String str = "List -> ";
      Node node = this.first;
      if (isEmpty()) {
        return "The list is empty";
      }else{
        for(int i = 1; i <= size(); i++){
          str += i + ") " + node.toString() + "  ";
          node = node.next;
        }
        return str;
      }
    }

    /*
        Remember when we try and run our java class file the JVM says cool let me check if you have a main method and then whatever we tell the JVM to do inside this method is carried out.

        Below we are going to create a new LinkedList, for example;
        LinkedList myList = new LinkedList();

        We add an element into that LinkedList by calling;
        myList.add(new Subject("Compilers", 70));

        Eplore what is happening down below and see if you can change the calls to add and remove more Subjects from our LinkedList...
    */
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.add(new Subject("Compilers", 70));
        myList.add(new Subject("Databases", 50));
        myList.add(new Subject("Web Development", 40));
        myList.add(new Subject("Java", 40));
        myList.add(new Subject("C", 40));
        System.out.println("The list is empty: " + myList.isEmpty());
        System.out.println("The size of the list is: " + myList.size());
        System.out.println("The average of the list's grades is: " +Math.round(myList.get_average()));
        System.out.println(myList.printList());
        myList.remove("C");
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println(myList.printList());
    }
}