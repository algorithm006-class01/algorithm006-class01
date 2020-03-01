package main

import "fmt"

/*
二叉树的最近公共祖先：
给定一个二叉树，找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
*/

/*
	递归法：自己想不到，看了题解
	按照老师说的四步：
	1.终止条件：如果此节点为nil，返回false
				如果此节点为p或q,返回true
	2.将到这层为止，这个节点与p,q的关系返回上一层（或直接得出结果），关系一共有以下几种：
		1.这个节点是其中节点之一的祖先
		2.这个节点不是任意一个节点的祖先
		3.这个节点是两个节点的公告祖先（即得出结果，因为一旦判定即返回，所以一定是最近祖先）
		ps：自己本身算是自己的祖先
	3.去下探下一层，左与右
	4.无资源需要清理

	上面的false 与 true是为方便表达，表示的是找到与最终没找到两个结果。实际上因为要设计判断是否是
	公共祖先，所以替换成返回0和1,这样是否是公共祖先可以用是否等于2来判断
*/

/*
	自己写完，发现犯了3个错误，123都用注释标记了。
	1. 这个错误应该算是递归的整体思路的错误。其实就是上面写的四步其实是有问题的。如果当前节点是p或q的话，
		也不应该是立即返回，因为如果这样的话，如果另一个节点是在它的叶子树中，由于已经提前返回了，所以就差不到了。
	2. res := &TreeNode{};
       这条语句并不是定义一个指向该类型的空指针。而是先定义出一个这个类型的结构，其成员都是零值，然后返回指向他的指针
	3. golang是值传递，所以传入函数的不应该是指针，而是指针的指针

	另外，我做完这个题，有个困惑就是：要么是覃老师关于递归的四步说的不太精准，要么就是我自己领悟错了。
	按照老师讲的第2步是处理这一层，他的下一步才是去到下一层。但按照这个题，我觉得处理处理这一层和去到下一层是混着的。
	因为对于每个节点，你要想判断他与p，q的关系，必然是已经把下面的层都探查完了。
*/

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func recursiveTree1(root, p, q *TreeNode, res **TreeNode) int {	//3.
	if root == nil {
		return 0
	}
	/*if root == p || root == q {	//	1.
		return 1
	}*/
	leftHave := recursiveTree1(root.Left, p, q, res)
	rightHave := recursiveTree1(root.Right, p, q, res)
	thisIs := int(0)
	if root == p || root == q {
		thisIs = 1
	}
	if thisIs + leftHave + rightHave >= 2 && *res == nil{
		*res = root
	}
	if thisIs + leftHave + rightHave >= 1 {
		return 1
	}
	return 0
}

func lowestCommonAncestor1(root, p, q *TreeNode) *TreeNode {
	//res := &TreeNode{}	//	2.
	var res *TreeNode  = nil
	recursiveTree1(root, p, q, &res)
	return res
}

/*
	看了另一个人写的递归，更加简洁。
	他用一种更加简洁的方法，使得当这个节点为p或q的时候，可以直接返回而不做判断。
	但是前提是，p q 两个节点必须是存在于给出的树中的
	如果是面试的时候,那么第一步就可以确定一下这个问题

	这种递归的思路：
		如果当前节点是p或q就直接返回当前节点
		对于下层，如果下层都是空则返回空，这个很简单，就是pq都不在这个节点的子树里
				如果两层都不为空，那么说明找到了，这个节点就是答案。
				如果有一层不为空，则直接把他的结果往上层反还（注意是结果，而不是左儿子节点）
				如果两次都为空，那么返回空
	为什么这样就可以省去第一种递归那么多的步骤呢？
	首先明确之所以第一种递归比较麻烦，就麻烦在于要考虑p,q本身即为答案的情况
	这个思路，他首先基于p,q节点必然存在于给出的树中这个条件。
	那么基于这个条件如果p,q节点本身为答案，我们直接把他往上一层层的返。在这个情况中，肯定会一直讲这个节点网上返直到根节点。因为不可能再
	找到另一个节点了。到了根节点，如果发现左右遍历，有一个的答案为空，那么直接返回另一个，就是答案。
	相当于，我们基于p,q节点必然存在于给出的树中这个条件，逆推出答案。
*/
func recursiveTree(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if root == p || root == q {
		return root
	}

	left := recursiveTree(root.Left, p, q)
	right := recursiveTree(root.Right, p, q)

	if left != nil && right != nil {
		return root
	}
	if left == nil && right != nil {
		return right
	}
	if left != nil && right == nil {
		return left
	}

	return nil
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	return recursiveTree(root, p, q)
}

func main() {
	node1 := TreeNode{
		Left:nil,
		Right:nil,
		Val:7,
	}
	node2 := TreeNode{
		Left:nil,
		Right:nil,
		Val:4,
	}
	node3 := TreeNode{
		Left:&node1,
		Right:&node2,
		Val:2,
	}
	node4 := TreeNode{
		Left:nil,
		Right:nil,
		Val:6,
	}
	node5 := TreeNode{
		Left:&node4,
		Right:&node3,
		Val:5,
	}
	node6 := TreeNode{
		Left:nil,
		Right:nil,
		Val:0,
	}
	node7 := TreeNode{
		Left:nil,
		Right:nil,
		Val:8,
	}
	node8 := TreeNode{
		Left:&node6,
		Right:&node7,
		Val:1,
	}
	node9 := TreeNode{
		Left:&node5,
		Right:&node8,
		Val:3,
	}
	res := lowestCommonAncestor(&node9, &node5, &node8)
	fmt.Println(res)
	return
}