/*
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */

class Solution {
public:
    // 使用环状替换，直接将元素放到最终的位置上
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        int cntRotated = 0;
        int length = nums.size();

        for (int start = 0; cntRotated < length; start++) {
            int current = start;
            int numToBeRotated = nums[start];  //当前元素

            do {
                int next = (current + k) % length;  //元素要放的位置
                int temp = nums[next];
                nums[next] = numToBeRotated;
                numToBeRotated = temp;
                current = next;
                cntRotated++;  //统计替换元素额个数
            } while (start != current);  // 避免循环复制
        }
    }

    // 采用反转法（三次反转）
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    void rotate2(vector<int>& nums, int k) {
        int length=nums.size();
        k = k % length;  // k可能大于n，这里保证k小于n

        reverse(&nums[0],&nums[length]);  // 反转所有元素
        reverse(&nums[0],&nums[k]);  // 反转前k个元素
        reverse(&nums[k],&nums[length]);  // 反转后n-k个元素
    }

    // 暴力法（超出运行时间），每次移动一步
    // 时间复杂度：O(n*k)
    // 空间复杂度：O(1)
    void rotate1(vector<int>& nums, int k) {
        int last, temp;
        int length = nums.size();
        for(int i=0; i<k; k++){
            last = nums[length-1];  // 第一个元素的上一个元素是最后一个元素
            for(int j=0; j<length; j++){
                temp = nums[j];
                nums[j] = last;
                last = temp;
            }
        }
    }
};
