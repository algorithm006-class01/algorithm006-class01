课后作业

003 
解题思路:
001 新建一个头节点 代理节点 
002 代理节点指向l1 l2中元素较小的点
003 代理节点更新到新增加的节点
004 返回头节点

class Solution {
public:
ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
ListNode *preHead = new ListNode(-1);
ListNode *pre = preHead;

while(l1&&l2){
if(l1->val >= l2->val){ //代理指针指向元素较小的节点
pre->next = l2;
l2 = l2->next; //l2指针指向下一个地址
}else{
pre->next = l1; 
l1 = l1->next; //l1指针指向下一个地址
}
pre = pre->next; //代理指针指向新加节点的位置
}

pre->next=l1 == NULL? l2 : l1; //判断l1 为空 那么返回l2 反之返回l1

return preHead->next; //返回新链表

}
};
