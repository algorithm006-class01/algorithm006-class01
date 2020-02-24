/*
 * @lc app=leetcode.cn id=429 lang=cpp
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if (!root)
        {
            /* code */return {};
        }
        vector<vector<int>> res;
        queue<Node*> que;
        que.push(root);
        int count=1;
        while (que.size())
        {
            /* code */vector<int> tmp;
            int inner_count=0;
            while (count>0)
            {
                /* code */Node* node=que.front();
                que.pop();
                tmp.push_back(node->val);
                count-=1;
                for (auto r : node->children)
                {
                    /* code */que.push(r);
                    inner_count+=1;
                }
                
            }
            res.push_back(tmp);
            count=inner_count;
        }
        return res;
        
    }
};
// @lc code=end

