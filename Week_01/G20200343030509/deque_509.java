import java.util.Deque;
import java.util.LinkedList;

class deque_509 {
  public static void main(String[] args) {
    Deque<String> deque = new LinkedList<String>();

    deque.addLast("a");
    deque.addLast("b");
    deque.addLast("c");
    System.out.println(deque);

    final String str = deque.peekLast();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.removeFirst());
    }
    System.out.println(deque);
  }
}