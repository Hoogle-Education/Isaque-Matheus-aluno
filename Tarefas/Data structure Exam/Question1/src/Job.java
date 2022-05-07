public class Job {
  
  private String name;
  private int arrivalTime;
  private int totalBurstTime;
  
  public Job(String name, int arrivalTime, int totalBurstTime) {
    this.name = name;
    this.arrivalTime = arrivalTime;
    this.totalBurstTime = totalBurstTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public int getBurstTime() {
    return totalBurstTime;
  }

  public void setBurstTime(int totalBurstTime) {
    this.totalBurstTime = totalBurstTime;
  }

  @Override
  public String toString() {
    return "Job [arrivalTime=" + arrivalTime + ", name=" + name + ", totalBurstTime=" + totalBurstTime + "]";
  }
  
}
