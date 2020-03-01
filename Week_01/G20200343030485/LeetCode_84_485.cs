public class Solution {
    public int LargestRectangleArea(int[] heights) {
        int areaMax = 0;

        Stack<int> stack = new Stack<int>();
        stack.Push(-1);

        for (int i = 0; i < heights.Length; i++)
        {
            int height = heights[i];
            while (stack.Peek() != -1 && heights[stack.Peek()] >= height)
            {
                int index = stack.Pop();
                int leftIndex = stack.Peek();
                int area = heights[index] * (i - leftIndex - 1);
                if (area > areaMax)
                {
                    areaMax = area;
                }
            }

            stack.Push(i);
        }

        // clear stack
        while (stack.Peek() != -1)
        {
            int index = stack.Pop();
            int left = stack.Peek();
            int right = heights.Length;
            int area = heights[index] * (right - left - 1);
            if (area > areaMax)
            {
                areaMax = area;
            }
        }

        return areaMax;
    }
}