/*
    in order to nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
    use hashmap to store each number
    find target - num in hashmap, that's the answer: (now index, hashmap's index)

    time complexity: O(n), space complexity: O(n)

*/
class Solution {
    public int[] twoSum(int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return new int[]{};
    }
}