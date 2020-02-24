一、 Queue源码分析

Queue和List一样都是Collection的子接口
```java
public interface Queue<E> extends Collection<E> {

    // 向队列中添加一个元素
    // 如果添加成功则返回true
    // 如果队列容量已满则抛出异常
    boolean add(E e);

    // 向队列中添加一个元素
    // 如果添加成功则返回true
    // 如果添加失败则返回false
    boolean offer(E e);

    // 移除对头元素
    // 返回对头元素，如果没有对头元素则抛出异常
    // throws NoSuchElementException
    E remove();

    // 移除对头元素
    // 返回对头元素，如果没有对头元素则返回null
    E poll();

    // 返回对头元素，不会删除对头元素
    // 如果没有对头元素则抛出异常
    // throws NoSuchElementException
    E element();

    // 返回对头元素，不会删除对头元素
    // 如果队列为空，则返回null
    E peek();
 }
```

 二、 Priority Queue源码分析
 
总结
1. 普通队列都是先进先出的，但是优先级队列是根据优先级进行确定的，优先级最高的先出队列；
2. 优先级队列类似于一颗完全二叉树，其内部实现使用的是数组
3. 优先级队列在数组中其元素不一定是完全有序的，但是在出队列时，其元素是有序的
4. 优先级队列插入和删除元素时，都需要对队列中的元素进行调整，其中remove()和add()方法的时间复杂度为O(log n)
而remove（Object obj）和contaions()方法需要O(n)时间复杂度，取对头元素只需要O(1)时间
5. 优先级队列是非同步的，队列中不允许使用null元素
```java

public class PriorityQueue<E> extends AbstractQueue<E>
        implements java.io.Serializable {

    private static final long serialVersionUID = -7720805057305804111L;

    //------------------------------初始化定义---------------------------------------------
    // 默认容量为11
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    // 元素的存储方式是数组
    transient Object[] queue; // non-private to simplify nested class access
    // 队列中元素的个数
    int size;
    // 比较器
    private final Comparator<? super E> comparator;
    // 队列修改的次数
    transient int modCount;     // non-private to simplify nested class access

    //-------------------------- 构造函数-------------------------------------
    // 创建一个默认容量（11）和自然顺序的优先级队列
    public PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }
    // 创建一个指定容量和自然顺序的优先级队列
    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }
    // 创建一个默认容量和指定比较器的优先级队列
    public PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }
    // 创建一个指定容量和包含指定集合元素的优先级队列，它分为三种情况：
    // 第一种：如果是一个已经排好序的集合，首先根据集合获取到他的比较器方法，然后将集合中的元素添加到队列中；
    // 第二种：如果是一个优先级队列，首先获取比较器方法，然后将指定优先级队列中的元素赋值到该队列中；
    // 第三种：其他情况默认使用自然比较器，将集合中的元素添加到队列中；
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    //创建一个包含指定优先级队列的队列，他的实现逻辑与（4）中的第二种情况相同；
    @SuppressWarnings("unchecked")
    public PriorityQueue(Collection<? extends E> c) {
        if (c instanceof SortedSet<?>) {
            SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
            this.comparator = (Comparator<? super E>) ss.comparator();
            initElementsFromCollection(ss);
        }
        else if (c instanceof PriorityQueue<?>) {
            PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
            this.comparator = (Comparator<? super E>) pq.comparator();
            initFromPriorityQueue(pq);
        }
        else {
            this.comparator = null;
            initFromCollection(c);
        }
    }

    //创建一个指定优先级的集合中的元素的队列
    @SuppressWarnings("unchecked")
    public PriorityQueue(PriorityQueue<? extends E> c) {
        this.comparator = (Comparator<? super E>) c.comparator();
        initFromPriorityQueue(c);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(SortedSet<? extends E> c) {
        this.comparator = (Comparator<? super E>) c.comparator();
        initElementsFromCollection(c);
    }

    // 初始化一个队列
    private void initFromPriorityQueue(PriorityQueue<? extends E> c) {
        if (c.getClass() == PriorityQueue.class) {
            this.queue = c.toArray();
            this.size = c.size();
        } else {
            initFromCollection(c);
        }
    }

    // 从集合中初始化数据到队列中
    private void initElementsFromCollection(Collection<? extends E> c) {
        // 将集合转成数组
        Object[] a = c.toArray();
        // 如果数组不是Object类型，转成Object类型
        if (a.getClass() != Object[].class)
            a = Arrays.copyOf(a, a.length, Object[].class);
        int len = a.length;

        if (len == 1 || this.comparator != null)
            for (Object e : a)
                if (e == null)
                    throw new NullPointerException();
        this.queue = a;
        this.size = a.length;
    }

    private void initFromCollection(Collection<? extends E> c) {
        initElementsFromCollection(c);
        heapify();
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    // 对数组的容量进行扩容
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50% 扩容的大小是翻倍或者50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        // overflow-conscious code 当数组的长度超过最大限制时，进行调整
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }

    //检验数组的长度是否超过限制，如果超过了进行调整或抛出异常
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    //向队列中插入了一个元素
    public boolean add(E e) {
        return offer(e);
    }

    //向队列中插入了一个元素
    public boolean offer(E e) {
        //如果元素为null，就抛出异常
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        // 如果队列中的元素个数大于或等于队列的长度，执行grow，对数组的容量进行扩容
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        // 如果队列中的元素为空，那么新加入的元素为第一个元素，直接赋值到0的位置，否则插入元素向上进程调整
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }

    //获取某个元素的索引位置，对数组进行遍历
    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(queue[i]))
                    return i;
        }
        return -1;
    }

    // 删除某一个元素
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1)
            return false;
        else {
            removeAt(i);
            return true;
        }
    }

    boolean removeEq(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == queue[i]) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(queue, size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        final int size = this.size;
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(queue, size, a.getClass());
        System.arraycopy(queue, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private final class Itr implements Iterator<E> {

        private int cursor;

        private int lastRet = -1;

        private ArrayDeque<E> forgetMeNot;

        private E lastRetElt;

        private int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor < size ||
                    (forgetMeNot != null && !forgetMeNot.isEmpty());
        }

        @SuppressWarnings("unchecked")
        public E next() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if (cursor < size)
                return (E) queue[lastRet = cursor++];
            if (forgetMeNot != null) {
                lastRet = -1;
                lastRetElt = forgetMeNot.poll();
                if (lastRetElt != null)
                    return lastRetElt;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if (lastRet != -1) {
                E moved = PriorityQueue.this.removeAt(lastRet);
                lastRet = -1;
                if (moved == null)
                    cursor--;
                else {
                    if (forgetMeNot == null)
                        forgetMeNot = new ArrayDeque<>();
                    forgetMeNot.add(moved);
                }
            } else if (lastRetElt != null) {
                PriorityQueue.this.removeEq(lastRetElt);
                lastRetElt = null;
            } else {
                throw new IllegalStateException();
            }
            expectedModCount = modCount;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++)
            queue[i] = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    //删除某个位置的元素
    @SuppressWarnings("unchecked")
    E removeAt(int i) {
        // assert i >= 0 && i < size;
        modCount++;
        //s为数组中的最后一个元素的位置
        int s = --size;
        if (s == i) // removed last element
            queue[i] = null;
        else {
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            //如果是最后一个元素替换到了删除的元素的位置，那么需要将元素进行向上比较，使其满足优先级队列的特性
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
    }

    // 在K位置插入元素X，同时对数组中的元素进行调整，使其满足队列的要求
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

    /**
     * 如果是默认比较器，插入元素时的调整方式
     * @param k
     * @param x
     */
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        // k大于0时，循环遍历K
        while (k > 0) {
            // 获取K的父节点
            int parent = (k - 1) >>> 1;
            // 获取父节点的元素e
            Object e = queue[parent];
            // 如果key的值大于等于其父节点的元素，那么不需要进行调整，结束操作
            if (key.compareTo((E) e) >= 0)
                break;
            // 否则的话将两个值进行对换，同时将k赋值为其父节点的位置
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }

    //如果有指定的比较器，插入元素之后的调整方法
    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }

    //向下调整队列中的元素
    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }

    //当无比较器时的下移操作的实现
    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        //half为队列的中间一半位置
        int half = size >>> 1;        // loop while a non-leaf
        //循环调整k，k小于中间位置索引值时循环
        while (k < half) {
            //获取k的左孩子索引值
            int child = (k << 1) + 1; // assume left child is least
            //获取左孩子的值
            Object c = queue[child];
            //获取k的右孩子索引值
            int right = child + 1;
            //如果存在右孩子，并且右孩子的值小于左孩子的值，那么将c值赋值为右孩子的值，也就是取左右孩子中值较小的那位
            if (right < size &&
                    ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            //如果key值小于等于孩子结点中的值，不需要调整，结束循环
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                    comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }

    @SuppressWarnings("unchecked")
    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            siftDown(i, (E) queue[i]);
    }

    public Comparator<? super E> comparator() {
        return comparator;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        // Write out element count, and any hidden stuff
        s.defaultWriteObject();

        // Write out array length, for compatibility with 1.5 version
        s.writeInt(Math.max(2, size + 1));

        // Write out all elements in the "proper order".
        for (int i = 0; i < size; i++)
            s.writeObject(queue[i]);
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in size, and any hidden stuff
        s.defaultReadObject();

        // Read in (and discard) array length
        s.readInt();

        queue = new Object[size];

        // Read in all elements.
        for (int i = 0; i < size; i++)
            queue[i] = s.readObject();

        // Elements are guaranteed to be in "proper order", but the
        // spec has never explained what that might be.
        heapify();
    }

    public final Spliterator<E> spliterator() {
        return new PriorityQueueSpliterator<>(this, 0, -1, 0);
    }

    static final class PriorityQueueSpliterator<E> implements Spliterator<E> {
        /*
         * This is very similar to ArrayList Spliterator, except for
         * extra null checks.
         */
        private final PriorityQueue<E> pq;
        private int index;            // current index, modified on advance/split
        private int fence;            // -1 until first use
        private int expectedModCount; // initialized when fence set

        /** Creates new spliterator covering the given range. */
        PriorityQueueSpliterator(PriorityQueue<E> pq, int origin, int fence,
                                 int expectedModCount) {
            this.pq = pq;
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() { // initialize fence to size on first use
            int hi;
            if ((hi = fence) < 0) {
                expectedModCount = pq.modCount;
                hi = fence = pq.size;
            }
            return hi;
        }

        public PriorityQueueSpliterator<E> trySplit() {
            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
            return (lo >= mid) ? null :
                    new PriorityQueueSpliterator<>(pq, lo, index = mid,
                            expectedModCount);
        }

        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> action) {
            int i, hi, mc; // hoist accesses and checks from loop
            PriorityQueue<E> q; Object[] a;
            if (action == null)
                throw new NullPointerException();
            if ((q = pq) != null && (a = q.queue) != null) {
                if ((hi = fence) < 0) {
                    mc = q.modCount;
                    hi = q.size;
                }
                else
                    mc = expectedModCount;
                if ((i = index) >= 0 && (index = hi) <= a.length) {
                    for (E e;; ++i) {
                        if (i < hi) {
                            if ((e = (E) a[i]) == null) // must be CME
                                break;
                            action.accept(e);
                        }
                        else if (q.modCount != mc)
                            break;
                        else
                            return;
                    }
                }
            }
            throw new ConcurrentModificationException();
        }

        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null)
                throw new NullPointerException();
            int hi = getFence(), lo = index;
            if (lo >= 0 && lo < hi) {
                index = lo + 1;
                @SuppressWarnings("unchecked") E e = (E)pq.queue[lo];
                if (e == null)
                    throw new ConcurrentModificationException();
                action.accept(e);
                if (pq.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return true;
            }
            return false;
        }

        public long estimateSize() {
            return (long) (getFence() - index);
        }

        public int characteristics() {
            return Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.NONNULL;
        }
    }
}
```

