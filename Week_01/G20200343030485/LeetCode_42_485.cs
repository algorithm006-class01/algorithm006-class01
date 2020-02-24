
public class Solution {
    public int Trap(int[] height) {
        int region = 0;
        Stack<int> stack = new Stack<int>();
        for (int i = 0; i < height.Length; i++) {
            int h = height[i];
            while (stack.Count != 0 && h > height[stack.Peek()]) {
                int indexToRemove = stack.Pop();
                if (stack.Count == 0) {
                    break;
                }

                int colWidth = i - stack.Peek() - 1;
                int colHeight = Math.Min(h, height[stack.Peek()]) - height[indexToRemove];
                region += colWidth * colHeight;
            }

            stack.Push(i);
        }

        return region;
    }
}