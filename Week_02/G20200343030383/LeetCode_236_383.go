// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
package leetcode

/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if _, n := findAncestor(root, p, q); n != nil {
		return n
	}
	return root
}

func findAncestor(root, p, q *TreeNode) (flag int,ret *TreeNode) {
        if root == nil {
                return 
        }
        var froot,fleft,fright int
        if root == p || root == q {
                froot = 1
        }
        if fleft, ret = findAncestor(root.Left, p, q);ret!=nil{
            return
        }
        if fright, ret= findAncestor(root.Right, p, q);ret!=nil{
            return
        }

        if froot+fleft+fright>1 {
                ret = root
        }
        return froot+fleft+fright,ret
}

func lowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	s := &st{}
	s.findAncestor(root, p, q, nil)
	size := min(len(s.ppath), len(s.qpath))
	for i := 0; i < size; i++ {
		if s.ppath[i] == s.qpath[i] && (i == size-1 || s.ppath[i+1] != s.qpath[i+1]) {
			return s.ppath[i]
		}
	}
	return root
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

type st struct {
	ppath, qpath []*TreeNode
}

func (t *st) findAncestor(root, p, q *TreeNode, path []*TreeNode) {
	if root == nil {
		return
	}
	path = append(path, root)
	if root == p {
		t.ppath = path
	}
	if root == q {
		t.qpath = path
	}
	if len(t.ppath) > 0 && len(t.qpath) > 0 {
		return
	}
	t.findAncestor(root.Left, p, q, path)
	t.findAncestor(root.Right, p, q, path)
}
