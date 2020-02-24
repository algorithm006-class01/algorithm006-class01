public int removeDuplicates(int[] nums) {
            if (nums.length == 0 || nums.length == 1) return nums.length;
            int j = 1;
            int i = 0;
            int index = 0;
            for (; i < j; i++) {
                
                while (nums[i] == nums[j]){
                    index++;
                    if(j >= nums.length - 1){
                        break;
                    } 
                    j++;
                }
                nums[i+1] = nums[j];
                j++;
                if(j >= nums.length){
                        break;
                } 
            }
            return nums.length - index;

    }
