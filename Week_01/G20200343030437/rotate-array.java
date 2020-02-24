 public void rotate(int[] nums, int k) {
            int length = nums.length;
            k = k % length;

            int current;
            int count = 0;
            for (int i = 0; count < length; i++) {
                int pre = nums[i];
                current = i;
                do {
                    int next = (current + k) % length;
                    int temp = nums[next];

                    nums[next] = pre;
                    pre = temp;
                    current = next;
                    count++;
                } while (i != current);
            }
        }
