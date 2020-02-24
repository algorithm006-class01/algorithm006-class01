学习笔记

树的遍历定义
	前序遍历：根结点 —> 左子树 —> 右子树
	中序遍历：左子树—> 根结点 —> 右子树
	后序遍历：左子树 —> 右子树 —> 根结点
	层次遍历：按层次遍历

前序 OR 中序 OR 后序 判断标准：根节点在 前中后的哪个位置

递归注意点
	1、不要人肉递归
	2、找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
	3、数学归纳法思维 （1、2都成立的时候 能证明n和n-1都成立）


递归代码模板
	public void recur(int level, int param) {
		//terminator
		if(level > MAX_LEVEL) {
			//process result
			return ;
		}

		//处理当前逻辑
		process(level, param);

		//进入下一个递归
		recur(level:level + 1, newParam);
		//restore current status
	}

回溯算法模板
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择

多叉树遍历模板
void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作
        traverse(child);
        // 后序遍历需要的操作
}

广度优先搜索
	使用队列
深度优先搜索
	使用栈
