/* 题目描述
 *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

//第二版代码, 速度0ms, 击败100%
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
	//考虑输入为NULL
	if ( l1 == NULL && l2 == NULL) return NULL;
	if ( l1 == NULL && l2 != NULL) return l2;
	if ( l2 == NULL && l1 != NULL) return l1;
	//哑节点
	struct ListNode *dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
	struct ListNode *cur = dummy;
	while( l1 != NULL && l2 != NULL){
		if ( l1->val > l2->val){
			cur->next = l2;
			l2 = l2->next;
		}  else{ 
			cur->next = l1;
			l1 = l1->next;
		}
		cur = cur->next;
	}
	cur->next = ( l1 == NULL) ? l2 : l1;
	return dummy->next;

}



//第一版代码
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){

    struct ListNode *new_node, *new_head;

    if ( l1 == NULL && l2 != NULL ) return l2;
    if ( l1 != NULL && l2 == NULL ) return l1;
    if ( l1 == NULL && l2 == NULL ) return NULL;

    //获取第一个节点
    if ( l1->val < l2->val ){
        new_node = l1;
        l1 = l1->next;
    } else{
        new_node = l2;
        l2 = l2->next;
    }
    new_head = new_node;

    while ( l1 != NULL && l2 != NULL){
        if ( l1->val < l2->val ){
            new_node->next = l1;
            l1 = l1->next;
        } else{
            new_node->next = l2;
            l2 = l2->next;
        }
        new_node = new_node->next;
    }
    new_node->next = l1 == NULL ? l2 : l1;
    return new_head;

}
