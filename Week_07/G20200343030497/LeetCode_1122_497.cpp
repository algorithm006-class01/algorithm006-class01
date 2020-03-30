class Solution {
public:
    // 时间复杂度：O(mn + nlogn)
    // 空间复杂度：O(nlogn)
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int tmp = 0;
        for(int i = 0; i < arr2.size(); i++){
            for(int j = 0; j < arr1.size(); j++){
                if(arr2[i] == arr1[j]){
                    swap(arr1[j], arr1[tmp]);  // 交换arr1中的元素
                    ++tmp;  // tmp之前的元素为拍好序的元素
                }
            }
        }
        
        // 对剩余元素排序
        sort(arr1.begin()+tmp, arr1.end()); 

        return arr1;
    }
};
