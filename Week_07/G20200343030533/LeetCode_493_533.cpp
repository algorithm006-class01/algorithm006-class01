#include <vector>
#include <iostream>

using namespace std;

//归并算法
class myMergeSort{
public:
    void mergeSort(vector<int> &arr){
        _mergeSort(arr, 0, arr.size() - 1);
        return ;
    }
    void _mergeSort(vector<int>& arr, int lo, int hi){
        if (lo >= hi) {
            return ;
        }

        int mid = lo + ( (hi-lo) >> 1 );
        _mergeSort(arr, lo, mid);
        _mergeSort(arr, mid+1, hi);
        merge(arr, lo, mid, hi);

        return ;
    }
    void merge(vector<int>& arr, int lo, int mid,  int hi){

        vector<int> tmp(hi-lo + 1, 0); //申请临时数组
        int i = lo, j = mid + 1;
        int k = 0;
        while ( i <= mid && j <= hi){
            if (arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            } else{
                tmp[k++] = arr[j++];
            }
        }
        while ( i <= mid) tmp[k++] = arr[i++];
        while ( j <= hi ) tmp[k++] = arr[j++];

        for ( int i = 0; i < tmp.size() ; i++){
            arr[i+lo] =  tmp[i];
        }

        return ;
    }
};


/*在本题目中使用归并

*/
class Solution {
public:
    int reversePairs(vector<int>& nums) {

        return mergeSort(nums, 0, nums.size()-1);
    }

    int mergeSort(vector<int>& nums, int lo, int hi){
        if ( lo >= hi) return 0;

        int mid = lo + ( (hi-lo) >> 1);
        int cnt = mergeSort(nums, lo, mid) + mergeSort(nums, mid+1, hi);
        //统计重要翻转对, nums[i] > 2*nums[j]
        //由于左右数组都是有序，那么 num[i] / 2 > nums[j]时, 则nums[i+1] /2 > nums[j]
        // 所以固定i, 然后移动j
        // j相对于 (mid+1)移动的位置，就是重要的翻转对
        for (int i = lo, j = mid+1 ; i <= mid; ++i){
            while( j <= hi && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid+1);
        }
        merge(nums, lo, mid, hi);

        return cnt;

    }

    void merge(vector<int>& nums, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        int k = 0;
        vector<int> temp(hi-lo+1, 0);
        while (i <= mid && j <= hi){
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= hi ) temp[k++] = nums[j++];
        for (int i = 0; i < temp.size(); i++){
            nums[i+lo] = temp[i];
        }
        return ;
    }
};



int main(int argc, char const *argv[])
{
    myMergeSort m;
    vector<int> arr{ 3,1,2,5,7};
    m.mergeSort(arr);
    for (int i = 0; i < arr.size(); i++) cout << arr[i] << ' ' ;
    cout << endl;

    /* code */
    return 0;
}
