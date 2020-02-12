/*接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 例如[0,1,0,2,1,0,1,3,2,1,2,1], 输出6
*/

//暴力法: 通过 224ms
//计算每个位置的左右最高的高度
//然后选择两者的较小者减去本身的高度
int trap(int* height, int heightSize){

	int ans = 0;
	
	//第0个位置和最后一个位置无法接水
	for ( int i = 1; i < heightSize - 1; i++){
		int max_left = height[i];
		int max_right = height[i];
		for ( int j = i ;j >= 0; j--){
			max_left = (max_left > height[j]) ? max_left : height[j];
		}
		for ( int j = i ;j < heightSize; j++){
			max_right = (max_right > height[j]) ? max_right : height[j];
		}
		ans += (max_left < max_right ? max_left : max_right) - height[i];

	}
	return ans;

}

//空间换时间: 8ms
//两次遍历，存放给定位置的左右最大值
int trap(int* height, int heightSize){
	if (heightSize == 0) return NULL; //特殊值
	int ans = 0;
	int *max_left = malloc(sizeof(int) * heightSize);
	int *max_right= malloc(sizeof(int) * heightSize);
	//记录每个位置的最大左边界
	max_left[0] = height[0];
	for (int i = 1; i < heightSize; i++){
		max_left[i] = height[i] > max_left[i-1] ? height[i] : max_left[i-1];
	}
	//记录每个位置的最大右边界
	max_right[heightSize-1] = height[heightSize-1];
	for (int i = heightSize-2; i >= 0; i--){
		max_right[i] = height[i] > max_right[i+1] ? height[i] : max_right[i+1];
	}
	
	for (int i = 1; i < heightSize - 1; i++){
		ans += (max_left[i] < max_right[i] ? max_left[i] : max_right[i]) - height[i];
	}

	free(max_left);
	free(max_right);
	return ans;
}

//栈:
typedef struct { 
    int *arr;
    int count;
} Stack;

int peek(Stack *st){
    return st->arr[st->count-1];
}

void pop(Stack *st){
    st->count--;
    return;
}

void push(Stack *st, int val){
    
    st->arr[st->count] = val;
    st->count++;
    return ;
}

bool empty(Stack *st){
    return st->count == 0 ? true : false;
}

int min(int a, int b){
    return a > b ? b : a;
}

int trap(int* height, int heightSize){
    if (heightSize == 0) return NULL;

    int ans = 0, current = 0;
    Stack * st = malloc(sizeof(Stack));
    st->arr = malloc(sizeof(int) * (heightSize+1));
    st->count = 0;

    while( current < heightSize){
        while( !empty(st) && height[current] > height[peek(st)]){
            int top = peek(st);
            pop(st);
            if ( empty(st)) break;
            int distance = current - peek(st) - 1;
            int bounded_height = min(height[current], height[peek(st)]) -height[top];
            ans += distance * bounded_height;
        }
        push(st, current++);
    }
    return ans;


}


