package follow.ice.phenix.leecode.week03;

public class JumpGame {

    private boolean jump(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (jump(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }
}
