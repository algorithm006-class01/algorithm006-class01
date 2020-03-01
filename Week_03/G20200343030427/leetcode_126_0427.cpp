class Solution {
	void dfs(unordered_map<string,unordered_set<string> > &trace, const string &last, vector<string> path, vector<vector<string> > &vs){
		path.push_back(last);
		if(trace.count(last)==0){
			reverse(path.begin(),path.end());
			vs.push_back(path);
			return;
		}
		for(const string &word:trace[last])
			dfs(trace,word,path,vs);
	}
public:
	vector<vector<string>> findLadders(string begin, string end, vector<string>& wordList) {
		unordered_set<string> dict(wordList.begin(),wordList.end());
		if (dict.count(end)==0) return {};
		unordered_map<string,unordered_set<string> > trace;
		unordered_set<string> q={begin}, dels;
		for(; q.size() && trace.count(end)==0; q=dels){
			for(const string &word:q)
				dict.erase(word);
			dels.clear();
			for(const string &word:q){
				for(int i=0; i<word.length(); ++i){
					string s=word;
					for(char ch='a'; ch<='z'; ++ch){
						if(word[i]==ch) continue;
						s[i] = ch;
						if(dict.find(s)==dict.end()) continue;
						trace[s].insert(word);
						dels.insert(s);
					}
				}
			}
		}
		if(trace.size()==0) return {};
		vector<vector<string> > result;
		dfs(trace,end,{},result);
		return result;
	}
};

