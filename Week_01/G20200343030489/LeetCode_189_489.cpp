/*方法一*/
/*class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int tmp[nums.size()];

        for (int i = 0; i < nums.size(); i++)
        {
            tmp[(i+k)%nums.size()]=nums[i];
        }
        for (int i = 0; i < nums.size(); i++)
        {
            nums[i]=tmp[i];
        }
        

    }
};*/
/*此方法因为多用了一个数组，导致空间复杂度不为O（1）*/

/*方法二*/

/*
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int tmp;
        for (int i = 0; i < k%nums.size(); i++)
        {
            tmp=nums[nums.size()-1];
            for (int j = nums.size()-1; j >0; j--)
            {
                nums[j]=nums[j-1];
            }
            nums[0]=tmp;
        }
    }
};
*/
/*此方法时间复杂度过高，为O(k*n)*/

/*方法三*/
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
       int leng=nums.size();
       k%=nums.size();
       reverse(&nums[0],&nums[leng]);
       reverse(&nums[0],&nums[k]);
       reverse(&nums[k],&nums[leng]);
    }
};

/*此方法运用了反转，反转reverse具体如下
这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。

在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn?k 个元素，就能得到想要的结果。
*/