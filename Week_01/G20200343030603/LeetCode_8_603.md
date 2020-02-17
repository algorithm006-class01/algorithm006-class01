用 add first 或 add last 这套新的 API 改写 Deque 的代码
```java
Deque<String> deque = new LinkedList<String>();

deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.prinln(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while(deque.size() > 0){
    System.out.println(deque.popFirst());
}
System.out.println(deque);
```