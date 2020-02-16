# 学习笔记

## 改写Deque
```java
class Rewrite {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst);
        }
        System.out.println(deque);
    }
}
```

## 学习总结
### 五步刷题法
 1. 第一遍
 * 5分钟：读题 思考
 * 直接看解法：多种解法，比较优劣
 * 背诵、默写好的解法
 
 2. 第二遍
 * 自己写，提交
 * 多种解法比较、体会——>优化
 
 3. 第三遍
 * 一天后，重复做题
 * 不同解法的熟练程度——专项刻意练习
 
 4. 第四遍
 * 一周后，反复回来练习相同的题目

### 编程思路
1. 自顶向下编程
2. 提提取重复部分
3. 升维思想 + 空间换时间
    
        