# 学习笔记（第三周）

**学号：** G20200343030601

**姓名：** 冯学智

**微信：** SDMrFeng

## 本周学习总结
- 因为发现预习资料基本都是王争老师数据结构和算法之美专栏里的内容，所以王争老师的课看了40%多了。王争老师的课更像是书本+课后题，覃超老师算法训练营更像是练习册和终点习题解读精讲。配合起来学习效果会比较好。

- 本周时间宽裕，做的题目也相对较多。在学习别人commit的代码的同时，对哪些代码复杂度更好、哪些代码更简洁、哪些代码更易懂进行了思考，在工程实现时，需要做相应的取舍。

- 对于某些题问是否有解，我会进一步思考有多少个解，每个解是什么样子；如果递增序列中允许重复值怎么来实现。多思考类似的问题，有助于巩固所学知识。

## 寻找旋转数组中的最小值（选招一个半有序数组中间无序的地方）

    /*
    * 思路: 二分思想 旋转数组中最小值，要么在数组的左半部分，要么在数组的右半部分
    * if 数组仅有一个元素或，lo值 < hi值
        数据是递增的，返回第一个值即可
    * if mid值 > hi值
    *    说明从lo到mid过程中经历过增长、猛降后再增长，最小值则在右半部分；
    *    递归处理右半部分；
    * else
    *    即最小值在左半部分；  
    *    递归处理左半部分；
    *
    * Note：注意有可能mid值恰好是最小值，所以不管左侧还是右侧递归，都带着mid值。
    *       (递归改为循环，以下代码经过精简)
    */

    // @lc code=start
    class Solution {
        /*
        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;

            while (lo < hi && nums[lo] > nums[hi]) {            
                // 数组片段长度>=2，且中间有起伏（旋转点在中间）
                int mid = (hi + lo) / 2;
                if (nums[lo] <= nums[mid])
                    lo = mid + 1; // mid前(含mid)递增，旋转点在mid之后
                else
                    hi = mid;  // mid前的片段有起伏，旋转点在mid前
            }

            // 数组片段仅有一个元素，或数组是递增的，直接返回第一个值
            return nums[lo];
        }
        */
        
        public int findMin(int[] nums) {
            return findMinCore(nums, 0, nums.length - 1);
        }

        private int findMinCore(int[] nums, int lo, int hi) {
            // 数组片段仅有一个元素，或数组是递增的，直接返回第一个值
            if (lo >= hi || nums[lo] < nums[hi])
                return nums[lo];

            int mid = (lo + hi) / 2;
            if (nums[lo] <= nums[mid])
                return findMinCore(nums, mid + 1, hi);
            else
                return findMinCore(nums, lo, mid);
        }       
    }