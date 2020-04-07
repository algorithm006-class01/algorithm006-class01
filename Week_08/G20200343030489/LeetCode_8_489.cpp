/*
 * @lc app=leetcode.cn id=8 lang=cpp
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
public:
    int myAtoi(string str) {
       long result(0);
       int size=str.size();
       int flag=1;
       bool start=false;
       for(int i=0;i<size;i++){
           if(str[i]==' '&&start==false)
                continue;
            if(str[i]=='-'&&start==false){
                flag=-1;
                start=true;
                continue;
            }
            if(str[i]=='+'&&start==false){
                flag=1;
                start=true;
                continue;
            }
            if(str[i]>='0'&&str[i]<='9'){
                start=true;
                result=result*10+str[i]-'0';
                if(flag*result>INT_MAX)
                    return INT_MAX;
                if(flag*result<INT_MIN)
                    return INT_MIN;
                continue;
            }
            else
                break;
       } 
       return flag*result;
    }
};
// @lc code=end

