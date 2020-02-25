//433. 最小基因变化
//https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description

//思路是127一样, 127题目的简化版

class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {

        //记录所有需要访问的节点
        unordered_set<string> candidate(bank.begin(), bank.end());
        //记录基因和step
        queue<pair<string ,int>> q;

        q.push({start, 0});

        string gene;
        int step;

        while( ! q.empty()) {
            //终止条件
            if (q.front().first == end){
                return q.front().second;
            }

            gene = q.front().first;
            step = q.front().second;
            q.pop();
// 遍历基因的每个碱基，然后将其进行替换，如果在基因库中有候选，那就完成一次突变，并且从基因库中将对应的基因删除。

            for (int i = 0; i < gene.length(); i++){
                char tmp =  gene[i]; //记录原状态
                for (char base : "ATCG"){
                    if (gene[i] == base) continue; //相同就不变化
                    gene[i] = base; //修改碱基
                    if( candidate.find(gene) != candidate.end()){
                        q.push({gene, step+1});
                        candidate.erase(gene);
                    }
                }
                gene[i] = tmp;

            }
        }
        return -1;

    }
};