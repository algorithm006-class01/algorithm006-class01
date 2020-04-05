#include <limits.h>

int myAtoi(char * str){

    long res = 0;
    int flag = 0;
    int str_size = strlen(str);
    //丢弃空格
    int i = 0;
    while ( str[i] == ' '){
        i++;
    }
    //非空字符后第一位
    if (str[i] == '-') {
        flag = 1;
        i = i + 1;
    } else if (str[i] == '+'){
        i = i + 1;
    } else if (str[i] >= '0' && str[i] <='9') {
    } else {
        return 0;
    }

    for (; i < str_size; i++){

        if (str[i] < '0' ||  str[i] > '9') break;
        if (str[i] >= '0' && str[i] <= '9') {
            if (res >= INT_MAX) break;
            res = res * 10 + (str[i] - '0');
        } 
    }
    if (flag == 1) res = -res;
    if (res < INT_MIN) {
        return INT_MIN;
    } 
    if (res > INT_MAX){
        return INT_MAX ;
    }
    return res;

}