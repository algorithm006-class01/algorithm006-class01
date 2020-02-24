class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size()==0) {
            return 0;
        }

        auto maxWater = 0;

        auto maxLeft = height[0];
        int* maxRight = new int[height.size()+1]();

        // Init right highest.
        for (int i=height.size()-1; i>=0; i--) {
            maxRight[i] = max(maxRight[i+1],height[i]);
        }

        for (int i=1; i < height.size()-1;i++) {
            auto maxHeight = maxLeft<maxRight[i+1]?maxLeft:maxRight[i+1];

            maxWater += maxHeight>height[i]?(maxHeight-height[i]):(0);

            maxLeft = max(maxLeft, height[i]);
        }

        return maxWater;
    }
};
