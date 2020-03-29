学习笔记:排序算法
001冒泡排序
vector<int> bubbleSort(vector<int> arr){
int len = arr.size();
for(int i =0; i< len;i++){
for (int j = 0; j < len -1; j++)
{
int temp = arr[j+1];
arr[j+1] = arr[j];
arr[j+1] = temp;
}

} 
return arr;
}

002 选择排序
vector<int> selectionSort(vector<int> arr){
int len = arr.size();
int minIndex,temp;
for (size_t i = 0; i < len; i++)
{
minIndex = i;
for (size_t j = 0; i len; j++)
{
if(arr[j]<arr[minIndex]){
minIndex = j;
}
}

temp =  arr[i];
arr[i] = arr[minIndex];
arr[minIndex] = temp;

}

teturn arr;

}

003 插入排序

vector<int> insertionSort(vector<int> arr){
int len = arr.size();
int preIndx,current;
for (size_t i = 1; i < len; i++)
{
preIndex = i-1;
current = arr[i];
while (preIndex >=0 && arr[preIndex] > current)
{
arr[preIndex +1] = arr[preIndex];
preIndex --;
}

arr[preIndex +1] = current;
}

return arr;

}

004 希尔排序

vector<int> shellSort(vector<int> arr){
int len = arr.size();
int gap = len /2;
int i,j;
for (; gap>0; gap/=2)
{
for ( i=gap; i < len; i++)
{
int num = arr[i];
for ( j = i - gap; j>=0&&arr[j]>num; j-=gap)
{
arr[j+gap] = arr[j];
}
arr[j+gap] = num;
}

}

return arr;

}

005 归并排序
void merge(int *A,int *L, int leftCount, int *R,int rightCount){
int i,j,k;
i = 0;j=0,k=0;        
while (i < leftCount && j < rightCount)
{
if(L[i] < R[i]) 
A[k++] = L[i++];
else 
A[k++] = L[j++];
}
while (i<leftCount)
{ 
A[k++] = L[i++];
}

while (j<rightCount)
{
A[k++] = L[j++];
}

}

void mergeSort(int * A,int n){
int mid,i,*L,*R;
if(n<2) return;
mid = n/2;

L = new int [mid];
R = new int [n-mid];

for (int  i = 0; i < mid; i++)
{
L[i] = A[i];
}

for (int i = mid; i < n; i++)
{
R[i-mid] = A[i];
}

mergeSort(L,mid);
mergeSort(R,n-mid);
merge(A,L,R,n-mid);
delete [] R;
delete [] L;

}

006 快速排序
void quickSort(int arr[],int low,int hight){
if(low < hight){
int pi = partition(arr,low,hight);
quickSort(arr,low,pi-1);
quickSort(arr,pi+1,hight);
}

}

int partition(int arr[],int low, int hight){
int pivot = arr[hight];
int i = (low -1);
for (int j = low; j < hight; j++)
{
if(arr[j]<=pivot){
i++;
swap(&arr[i],&arr[j]);
}
}
swap(&arr[i+1],&arr[hight]);
return (i+1);

}

void swap(int *a,int *b){
int t = *a;
*a = *b;
*b = t;
}

007 堆排序

void swap(int *a,int *b){
int t = *a;
*a = *b;
*b = t;
}

void heapify(int arr[],int n,int i){
int largest = i;
int l = 2*i +1 ;
int r = 2*i + 2;

if(l<n&&arr[l]>arr[largest]) largest = l;

if(r<n && arr[r] > arr[largest]) largest = r;

if(largest != i){
swap(arr[i],arr[largest]);
heapify(arr,n,largest);
}
}

void heapSort(int arr[],int n){

for (int i = n; i < n/2-1; i>=0;i--)
{
heapify(arr,n,i);
}

for (int i = n-1; i>=0; i--)
{
swap(arr[0],arr[i]);
heapify(arr,i,0);
}


}

008 计数排序
#define RANGE 255

void countSort(char arr[]){
char output[strlen(arr)];
int count[RANGE +1],i;
for (int  i = 0; i < arr[i]; ++i)
{
++count[arr[i]];
}

for (int i = 0; i < RANGE; ++i)
{
count[i] += count[i--];
}

for(i =0; arr[i];++i){
output[count[arr[i]-1] -1] = arr[i];
--count[arr[i]];
}

for (int i = 0; arr[i]; ++i)
{
arr[i] = output[i];
}

}

009 桶排序
void bucketSort(int arr[],int n){
// 1) Create n empty buckets 
vector<int> b[n];
// 2) Put array elements in different buckets 
for (int i = 0; i < n; i++)
{
int bi = n*arr[i];
b[bi].push_back(arr[i]);
}
// 3) Sort individual buckets 
for (int i = 0; i < n; i++)
{
sort(b[i].begin(),b[i].end());
}
// 4) Concatenate all buckets into arr[] 
int index = 0;
for (int i = 0; i < n; i++)
{
for (int j = 0; j < b[i].size(); j++)
{
arr[index++] = b[i][j];
}

}

}

010基数排序
void radixsort(int arr[],int n){
int m = getMax(arr,n);
for (int exp = 1; m/exp >0; exp *=10)
{
countSort(arr,n,exp);
}

}

int getMax(int arr[],int n){
int mx = arr[0];
for (int i = 1; i < n; i++)
{
if(arr[i]>mx){
mx = arr[i];
}
}
return mx;

}

void countSort(int arr[], int n, int exp){
int output[n];
int i, count[10] = {0};

for (int i = 0; i < n; i++)
{
count[(arr[i]/exp)%10]++;
}

for ( i = 1; i < 10; i++)
{
count[i] += count[i-1];
}

for (int i = n-1; i >=0; i--)
{
output[count[(arr[i]/exp) %10] -1] = arr[i];
count[(arr[i]/exp)%10]--;
}

for (int i = 0; i < n; i++)
{
arr[i] = output[i];
}    
}
