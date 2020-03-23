#include <vector>

using namespace std;
/*桶排序*/
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> temp(1001,0);
        for (int i : arr1){
            temp[i]++; //统计arr1中每个桶的数目
        }
        int index = 0;
        for ( int j : arr2){ //根据arr2获取桶里面的元素
            while( temp[j] > 0){
                arr1[index] = j;
                temp[j]--;
                index++;
            }
        }
        //以此取出桶里剩下的元素
        for (int i = 0; i < temp.size(); i++){
            while ( temp[i] > 0){
                arr1[index] = i;
                temp[i]--;
                index++;
            }
        }
        return arr1;
    }
};