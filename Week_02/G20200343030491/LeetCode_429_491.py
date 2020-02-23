class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        res = {} 
        s, level = [root], 0
        while s:
            level += 1
            res[level] = []
            ns = []
            for i in s:
                res[level].append(i.val)
                ns.extend(i.children)
            s = ns
        return res.values()


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        res = [] 
        s = [root]
        while s:
            l = []
            ns = []
            for i in s:
                l += [i.val]
                ns.extend(i.children)
            res.append(l)
            s = ns
        return res


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        lev, res = 0, {}
        
        def rec(node,level):
            if not node:
                return
            
            res[level] = res.get(level,[])+[node.val]
            
            for i in node.children:
                rec(i,level+1)
        
        rec(root,lev)
        return res.values()