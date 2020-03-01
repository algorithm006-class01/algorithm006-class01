
//C语言做法，整体逻辑和Cpp一样，就是内存需要手动分配
void generate(int n, int left, int right, char** ret, char *s, int*returnSize){
    if (left == n && right == n){
        s[left+right] = '\0';
        ret[*returnSize] = strdup(s);
        *returnSize = *returnSize + 1;
        return ;
    }
    if (left < n){
        s[left+right] = '(';
        generate(n, left+1, right, ret, s, returnSize);
    }
    if (right < left){
        s[left+right] = ')';
        generate(n, left, right+1, ret, s, returnSize);
    }
    return ;

}

int comb(int n){
    int ret = 1;
    for (int i = 1; i <= n; i++){
        ret *= i;
    }
    return ret;
}

char ** generateParenthesis(int n, int* returnSize){
    char *s = malloc(sizeof(char) * n * 2 +1);
    *returnSize = 0; //默认是0
    int initSize = comb(n);
    char **ret = malloc(sizeof(char*) * initSize);
    generate(n, 0, 0, ret, s, returnSize);
    return ret;

}
