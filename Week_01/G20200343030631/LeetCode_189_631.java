// Version1
public static void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0){
        return;
        }
        // 每次右移1个，循环多次
        for (int i = 0; i < k; i++) {
        rotateOneStep(nums);
        }
        }

private static void rotateOneStep(int[] nums) {
        int previous = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
        int temp = nums[i];
        nums[i] = previous;
        previous = temp;
        }
        }
// Version2
private static void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0){
        return;
        }
        // 需多次使用数组长度，避免每次获取；
        int length = nums.length;
        int[] tmp = new int[length];
        for (int j = 0; j < length; j++) {
        int newLoc = (j + k) % length;
        tmp[newLoc] = nums[j];
        }
        for (int j = 0; j < length; j++) {
        nums[j] = tmp[j];
        }
        }
// Version3
private static void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0){
        return;
        }
        int length = nums.length;
        // 当K大于数据长度时，没必要多次执行旋转
        k %= length;
        // 翻转整个数组
        reverse(nums, 0, (length - 1));
        // 翻转前K个
        reverse(nums, 0, (k - 1));
        // 翻转剩余n-k个
        reverse(nums, k, (length - 1));
        }

private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
        // 两两交换
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
        start++;
        end--;
        }
        }
// Version4
private static void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
        return;
        }
        int length = nums.length;
        // 当K大于数据长度时，没必要多次执行旋转
        k %= length;
        int num = 0;
        for (int start = 0; num < length; start++) {
        int current = start;
        int previous = nums[start];
        do {
        int next = (current + k) % length;
        int tmp = nums[next];
        nums[next] = previous;
        previous = tmp;
        current = next;
        num++;
        } while (start != current);
        }
        }