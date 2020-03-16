public class Solution {
    public bool CanJump(int[] nums) {
        int jumpTargetMax = 0;
        for (int i = 0; i < nums.Length; i++) {
            if (i > jumpTargetMax) {
                return false;
            }

            jumpTargetMax = Math.Max(jumpTargetMax, i + nums[i]);
        }

        return true;
    }
}