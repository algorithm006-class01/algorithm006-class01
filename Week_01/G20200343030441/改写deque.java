import java.util.Deque;
import java.util.LinkedList;

public class DoubleQueue {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);


    }
}