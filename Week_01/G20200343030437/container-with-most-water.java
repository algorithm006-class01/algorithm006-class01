public int maxArea(int[] height) {
  //常规双指针写法
  int length = height.length;
  int maxarea = 0;
  int l = 0;
  int r = length-1;

  while(l != r){
 	 maxarea = Math.max(maxarea, (r - l) * Math.min(height[l], height[r]));
         if (height[l] < height[r]){
              l ++;
         }else {
              r --;
         }
  }
  return maxarea;
 }
