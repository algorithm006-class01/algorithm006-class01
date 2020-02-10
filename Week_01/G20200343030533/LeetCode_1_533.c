/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

struct hashtable {
    int key;                    /* key */
    int value;
    UT_hash_handle hh;         /* makes this structure hashable */
};

void add(struct hashtable **table, int num, int idx) {
    //申请一个结构存放数据
    struct hashtable *s;
    s = malloc(sizeof(struct hashtable));
    s->key = num;
    s->value = idx;
    HASH_ADD_INT((*table), key, s );  /* id: name of key field */
}


//一遍哈希法
// 从头往后遍历，检查target - nums[i] 是否在hash表中
// 如果不在, 以值为key，下标为value进行存放
int* twoSum(int* nums, int numsSize, int target, int* returnSize){

    struct hashtable  *table = NULL; //新建哈希表 
    struct hashtable  *tmp; //用于存放找到中间结果
    *returnSize = 2;
    int *res  = (int*)malloc(sizeof(int) * *returnSize);

    int remain;
    for(int i = 0; i < numsSize; i++){
        remain = target - nums[i]; //剩余值
        // 在表table中查找remin, 如果有结果，返回tmp
        HASH_FIND_INT(table, &remain, tmp);
        if ( tmp == NULL ){
            add(&table, nums[i], i);
        } else {
            res[1] = i;
            res[0] = tmp->value;
            break;
        }

    }

    return res;

}
