学习总结:
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

1.clarification: 找到中间无序的地方
二分查找的调节
001 存在边界
002 存在局部单调递增
003 可以通过索引进行访问

二分法 找到数组中无序的边界点 得到一个单调递增的数组上下边界
然后进行二分法寻找target

解法如下:
class Solution {
public:
int binarySearch(vector<int>& nums, int l, int r, int target) {
while (l <= r) {
int p = (l + r) / 2;
if (nums[p] == target)
return p;
if (nums[p] > target)
r = p - 1;
else
l = p + 1;
}

return -1;
}

int search(vector<int>& nums, int target) {
if (nums.empty())
return -1;

int l = 0;
int r = nums.size() - 1;
int p; // Position of boundary

while (l <= r) {
p = (l + r) / 2;
// 边界是最后一个 或者边界的值大于右边就break
if (p == nums.size() - 1 || nums[p] > nums[p + 1])
break;
// 
if (nums[l] > nums[p]) //左半部分存在无序就
r = p - 1;
else 
l = p + 1; //右边部分存在无序
}

if (p == nums.size() - 1) //
return binarySearch(nums, 0, nums.size() - 1, target);
int pos = binarySearch(nums, 0, p, target); //左半部分找
if (pos != -1)
return pos;
return binarySearch(nums, p + 1, nums.size() - 1, target); //右半部分找
}
};




