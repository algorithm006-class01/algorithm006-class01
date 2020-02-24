学习笔记

本周的学习继续懵圈中，到了这周，感觉用JavaScript的有点跟不上，需要上网找很多相关的资料来看，然后再对应老师视频里所说的内容，进行理解，感觉还是挺吃力的，不过呢。。真的很有趣啊有木有，左右是树的左右啊，不是图放左一点，不不不，再放右一点，字往左一点，不不不，还是往右一点好看。。。鉴于以上情况，下周需要投入更多的时间进行学习，不然要跟不上了。
简单的总结
    关于哈希表
        通过一个哈希函数(有现成，也可以自己写),将一个key值，转化为真实数据所存储的数组中对应的下标值，以实现将数据分散存储却又能快速查找的方式

    关于二叉树
        树就是一种特殊的链表
        关于树的遍历
        前序（根左右）
            def preorder(self, root)
              if root:
                self.traverse_path append(root.val)
                self.preorder(root.left)
                self.preorder(root.right)
        中序（左根右）
            def inorder(self, root)
              if root:
                self.inorder(root.left)
                self.traverse_path append(root.val)
                self.inorder(root.right)
        后序（左右根）
            def psostorder(self, root)
              if root:
                self.psostorder(root.left)
                self.psostorder(root.right)
                self.traverse_path append(root.val)

    关于递归
        简单的理解，就是自己调用自己
        递归事例代码
        来自Python的示例
        def recursion (level, param1, param2) {
            # recursion terminator 递归终结条件
            if level > MAX_LEVEL
              process_result
              return

            # process logic in current level  处理当前层逻辑
            process(level, data...)

            # drill down  下探到下一层
            self.recursion(level+1,p1,...)

            #reverse the current level status if needed  如有必要的话，清理当前层
        }

        注意事项：
        抵制人肉递归
        找最近重复子问题（重复性）
        数学归纳法