package Week_02;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_590_001 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if(root == null){
            return res;
        }

        for(Node c : root.children){
            postorder(c);
        }

        res.add(root.val);

        return res;

    }
}
