/*
* address: https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
* input:  { val: 1,
  children:
   [ { val: 3, children: [] },
     { val: 2, children: [] },
     { val: 4, children: [] }
   ]
   }
* output: [5,6,3,2,4,1]
* */

/*
Method 1: recursion
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
const postorder = (root) => {
    let list = [];
    generate(root, list);
    return list;
};

const generate = (root, list) => {
    if (root == null) {
        return null;
    }

    for (let i = 0; i < root.children.length; i++) {
        generate(root.children[i], list);
    }

    list.push(root.val);
    return list;
};
console.log(postorder(list));
