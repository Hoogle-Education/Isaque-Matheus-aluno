public class Node<T extends Comparable<T>> {
  
  T element;
  Node<T> left;
  Node<T> right;

  public Node(T element) {
    this.element = element;
  }

  @Override
  public String toString() {
      String leftVal = (left == null ? "empty" : left.element.toString());
      String rightVal = (right == null ? "empty" : right.element.toString());
      return "Node{" + "\n   element= " 
              + element + "\n   left= " 
              + leftVal + "\n   right= " 
              + rightVal + "\n}";
  }


}
