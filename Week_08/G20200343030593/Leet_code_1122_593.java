class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt=new int[1001];
        for(int i:arr1){
            cnt[i]++;
        }
        int c=0;
        for(int i:arr2){
            while(cnt[i]-->0){
                arr1[c++]=i;
            }
        }
        for(int i=0;i<cnt.length;i++){
            while(cnt[i]-->0){
                arr1[c++]=i;
            }
        }
        return arr1;
    }
}