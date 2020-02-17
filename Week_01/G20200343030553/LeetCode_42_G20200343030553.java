class Solution {
    public int trap(int[] height) {
        int sum = 0;

        for(int i=1;i<height.length-1;i++){
            int maxl = 0;
            int maxr = 0;
            for(int j=i;j>=0;j--){
                maxl = Math.max(maxl, height[j]);
            }
            for(int j=i;j<height.length;j++){
                maxr = Math.max(maxr, height[j]);
            }

            sum += Math.min(maxl, maxr) - height[i];
        }

        return sum;
    }
}