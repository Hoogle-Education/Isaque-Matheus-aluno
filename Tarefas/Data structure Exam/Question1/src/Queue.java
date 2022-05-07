public class Queue {
 
  Node first;
  Node last;

  public void add(Job job){
    
    if(first == null){
      first = new Node(job);
      last = first;
    } else {
      // add at the end
      Node temp = new Node(job);
      last.next = temp;
      last = temp;
    }

  }

  public boolean isEmpty(){
    if(first == null) 
      return true;
    else 
      return false;
  }

  public int readySize(){
    Node temp = first;
    int size = 0;

    while(temp != null){
      size++;
      temp = temp.next;
    }

    return size;
  }

  public double get_average(){

    Node temp = first;
    int timeElapsed = 0;

    double sum = 0.0;

    while(temp != null){
      sum += timeElapsed - temp.job.getArrivalTime();
      timeElapsed += temp.job.getBurstTime();
      temp = temp.next;
    }

    return sum/(double)readySize();
  }

  public double get_averageTurnroundTime(){
    Node temp = first;
    int timeElapsed = 0;

    double sum = 0.0;
    while(temp != null){
      timeElapsed += temp.job.getBurstTime();
      int turnroundTime = timeElapsed - temp.job.getArrivalTime();
      sum += (double)turnroundTime;
      temp = temp.next;
    }

    return sum/(double)readySize();
  }

  public void remove(){
    
    if(first == null) return;

    first = first.next;
  }

  public void startPool() throws InterruptedException {
    Node temp = first;
    int timeElapsed = 0;

    while (temp != null){
      String name = temp.job.getName();
      long time = temp.job.getBurstTime();

      System.out.println("Time " + timeElapsed + ": The process " + name + " has arrived into pool!");
      
      // "wait the job finish"
      Thread.sleep((long)(time*1000));

      // process terminated with success
      System.out.println("Time " + timeElapsed + ": Process " + name + "has been sent to CPU and is executed for " + time + " time intervals");

      timeElapsed += temp.job.getBurstTime();
      temp = temp.next;
    }
  }

}
