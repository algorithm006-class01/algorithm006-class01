public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int length = nums.length;
            if (nums == null || length < 3) return ans;
            Arrays.sort(nums);
            if (nums[0] > 0) return ans;

            int newlen = length - 2; //减少计算次数
            for (int i = 0; i < newlen; i++) {
                int l = i + 1;
                int r = length-1;
                if (i > 0 && nums[i] == nums[i-1]) continue;
                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++; //去重
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return ans;
        }
