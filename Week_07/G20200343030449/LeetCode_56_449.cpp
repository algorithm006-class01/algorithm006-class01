class Solution {
public:
    inline static bool internalCompare(const vector<int> &lhs, const vector<int> &rhs) {
        for (int i=0;i<lhs.size();i++) {
            if (lhs[i]>rhs[i]) return false;
            if (lhs[i]<rhs[i]) return true;
        }

        return false;
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        sort(intervals.begin(),intervals.end(),internalCompare);

        vector<int> current;

        for (int i=0;i<intervals.size();i++) {
            if (i==0) current=intervals[i];

            if (!mergeTwo(current,intervals[i])) {
                ans.push_back(current);
                current = intervals[i];
            }
        }

        if (!current.empty()) ans.push_back(current);

        return ans;
    }

    bool mergeTwo(vector<int> &a, const vector<int> &b) {
        if (a[1] < b[0]) {
            return false;
        }

        if (a[1] < b[1]) a[1] = b[1];

        return true;
    }
};
