学习笔记

本周学习总结
    自己找资料学习了JavaScript的栈和队列的知识，算是搞懂了，
    栈和队列只是一种有特定特性的数据结构
    栈只要符合后进先出，队列只要符合先进先出，那么在JavaScript中，使用数组或是
    使用对象来定义都是可以的，但是JavaScript中并没有私有属性的设定，所以即使使用
    对象来生命一个栈或是队列，都没法完全保证内部数据的安全性

深度优先遍历，以二叉树为例子的话，
    先遍历左子树，遍历到底，然后再依次返回遍历对应层的右子树，先往垂直方向走再往
    横向走
关于深度优先遍历的模板如下
    visited = set()
    dfs (node, visited) {
        if node in visited:
            return
        visited.add(node)

        for next_node in node.children():
            if not next_node in visited:
                dfs(next_node, visited)
    }
广度优先遍历，以二叉树为例子：
    先遍历每一层的所有元素，再深入到下一层，既每深入一层，都将当前层遍历完了再深入
    下一层
关于广度优先遍历的模板
    visited = set()
    bfs(graph, start, end) {
        queue = []
        queue.append([start])
        visited.add(start)

        while queue:
            node = queue.pop()
            visited.add(node)

            process(node)
            nodes = generate_related_nodes(node)
            queue.push(nodes)
    }

关于贪心算法，贪心算法中，每一步都获取当前的最优解
    贪心 + 回溯 = 动态规划

关于二分查找
    二分查找的前提
        1、目标函数的单调性 （单调递增或递减）
        2、存在上下界
        3、能够通过索引访问
二分查找的模板
    left,right = 0, len(array) - 1
    while left <= right:
        mid = (left + right) / 2
        if (array[mid] === target) {
            break or return result
        } else if (array[mid] < targe) {
            left = mid + 1
        } else {
            right = mid - 1
        }

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在第 3 周的学习总结中

思路： 因为是半有序，所以无序节点的左右两边各自都是有序的
      所以二分查找，中间位置，对比mid 与 mid - 1 与 mid + 1之间的关系
      如果仍是一个顺序关系，则将left定位mid

function findDisorderIndex(arr) {
    let [left, right, mid] = [0, arr.length - 1, 0]
    while (left <= right) {
        mid = (left + right) / 2
        if (arr[mid] < arr[mid - 1] || arr[mid] > arr[mid + 1]) {
            return mid
        } else {
            left = mid
        }
    }
}