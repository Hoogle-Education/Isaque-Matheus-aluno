public interface BinarySearch <T extends Comparable<T>> {
 
  public void add(T element);

  public boolean isEmpty();
  
  public int count();
  
  public T findMax();
  
  public T findMin();

}
