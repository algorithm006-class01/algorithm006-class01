/*
* address: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
* */
const root = {
    val: 1,
    children:
        [
            {
                val: 3, children: [
                    {val: 5, children: []},
                    {val: 6, children: []}]
            },
            {val: 2, children: []},
            {val: 4, children: []}]
};

const preorder = (root) => {
    let list = [];
    generate(root, list);
    return list;
};
const generate = (root, list) => {
    if(root==null)return null;
    list.push(root.val);
    for (let i = 0; i < root.children.length; i++) {
        generate(root.children[i], list);
    }
};
console.log(preorder(root));
