package cn.geek.week2;

import java.util.List;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月22日 22:38:00
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
