#define STACKSZIE 100
typedef struct {
	int *arr;
	int count;
	int size;
} Stack;

typedef struct {
	Stack *data;
	Stack *helper;
    
} MinStack;

/** initialize your data structure here. */

MinStack* minStackCreate() {

	MinStack *obj = (MinStack *)malloc(sizeof(MinStack));
	// 使用数组作为栈, 大小固定 
	obj->data = (Stack *)malloc(sizeof(Stack));
	obj->data->arr = (int *)malloc(sizeof(int) * STACKSZIE);
	obj->data->size = STACKSZIE;
	obj->data->count = 0;
	
	obj->helper = (Stack *)malloc(sizeof(Stack));
	obj->helper->arr = (int *)malloc(sizeof(int) * STACKSZIE);
	obj->helper->size = STACKSZIE;
	obj->helper->count = 0;

	return obj;
    
}

void minStackPush(MinStack* obj, int x) {

	//辅助栈为空
	if ( obj->helper->count == 0 ){
	    obj->helper->arr[obj->helper->count] = x;
	    obj->helper->count++;
	} else {
		//判断新增的元素是否小于等于辅助栈的顶部元素
		if ( x <= obj->helper->arr[obj->helper->count-1] ){
			obj->helper->arr[obj->helper->count] = x;
	        obj->helper->count++;	
		}
	}

	obj->data->arr[obj->data->count] = x;
	obj->data->count++;
  
}

void minStackPop(MinStack* obj) {
	//检查是否为空
	if ( obj->data->count == 0 ) return ;

	//检查数据栈和辅助栈是否相同
	int x = obj->data->arr[obj->data->count-1];
	int y = obj->helper->arr[obj->helper->count-1];

	if ( x == y) {
		obj->helper->count--;
	}

	obj->data->count--;
  
}

int minStackTop(MinStack* obj) {
	
	return obj->data->arr[obj->data->count-1];
  
}

int minStackGetMin(MinStack* obj) {

	return obj->helper->arr[obj->helper->count-1];
  
}

void minStackFree(MinStack* obj) {
	
	free(obj->data->arr);
	free(obj->data);
	free(obj->helper->arr);
	free(obj->helper);
	free(obj);
}

/**
 * Your MinStack struct will be instantiated and called as such:
 * MinStack* obj = minStackCreate();
 * minStackPush(obj, x);
 
 * minStackPop(obj);
 
 * int param_3 = minStackTop(obj);
 
 * int param_4 = minStackGetMin(obj);
 
 * minStackFree(obj);
*/
