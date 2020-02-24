import java.util.ArrayDeque;

public class Deque {
    public static void main(final String[] args) {
        final ArrayDeque<String> deque = new ArrayDeque<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        final String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
} // class定义结束