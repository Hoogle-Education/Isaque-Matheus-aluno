import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <T extends Comparable<T>> implements BinarySearch<T>{
 
  Node<T> root;

  @Override
  public void add(T elem) {
        if(isEmpty()) root = new Node<T>(elem);
        else add(elem, root);
  }

  private void add(T elem, Node<T> temp){

    if(elem.compareTo(temp.elem) < 0){
      if(temp.left == null) // is anyone in left ?
        temp.left = new Node<>(elem);
      else
        add(elem, temp.left);
    } else {
      if(temp.right == null) // is anyone in right ?
        temp.right = new Node<>(elem);
      else 
        add(elem, temp.right);
    }

  }

  
  @Override
  public int count() {
    return count(root);
  }
  
  public int count(Node<T> temp){
    
    if(temp == null) return 0;
    else return 1 + count(temp.left) + count(temp.right);
    
    
    
  }
  
  @Override
  public boolean isEmpty() {
    return (root == null) ? 
                true : false;
  }

  @Override
  public T findMax() {
    if(isEmpty()) throw new TreeException();
    else return findMax(root);
  }

  public T findMax(Node<T> temp){
    if(temp.right == null) return temp.elem;
    else return findMax(temp.right);
  }

  @Override
  public T findMin() {
    if(isEmpty()) throw new TreeException();
    else return findMin(root);
  }

  public T findMin(Node<T> temp){
    if(temp.left == null) return temp.elem;
    else return min(temp.left);
  }

  @Override
  public String toString() {
    String straux = "" ;
    Queue<Node<T>> aux = new LinkedList<>();
    aux.add(root);

    while(!aux.isEmpty()){

      aux += aux.elem().toString();
      aux += "\n";
      
      if(aux.elem().right != null) aux.add(aux.elem().right);
      
      if(aux.elem().left != null) aux.add(aux.elem().left);
        
        aux.remove();

    }
    
    return straux;
  }

}
