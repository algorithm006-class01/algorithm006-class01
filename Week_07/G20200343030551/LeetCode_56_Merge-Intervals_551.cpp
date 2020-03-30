#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        if (!intervals.size())
            return {};

        //先把区间按端点从小到大进行排序
        sort(intervals.begin(), intervals.end(), less<vector<int>>());

        int pos = 0;
        for (int i = 0; i < intervals.size(); i++)
        {
            if (intervals[pos][1] > intervals[i][0])
            {
                intervals[pos][1] = max(intervals[pos][1], intervals[i][1]);
            } else
            {
                intervals[++pos] = intervals[i];
            };
        }
        intervals.resize(pos + 1);
        return intervals;
    }
};