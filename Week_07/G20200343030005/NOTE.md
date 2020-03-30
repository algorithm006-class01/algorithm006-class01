学习笔记
线性查找：

<script>  
var arr = [4,3,2,1];  
var arr = [-10,-34,48,23,0,1,4,12];  
  
function findInArr(arr,n){  
    for(var i = 0; i < arr.length; i++){  
        if(arr[i] == n){  
            return i;//true  
        }  
    }  
    return -1;//false  
}  
  
document.write(findInArr(arr,13));  
</script>

二分查找

<script>  
var arr = [1,3,4,5,6,7,8,9,10];  
var arr = [11];  
//二分查找 条件 必须是有序数组 使用递归的方  
/* 
    c  中点 Math.floor、round、ceil((起点+终点)/2) 只要是整数就行 (s+e)/2 
    n  n == arr[c] 直接命中 
    n  n<arr[c]在左边找 [s,c-1] 
    n  n>arr[c]在右边找 [c+1,e] 
     
*/  
function binarySearch(arr,n,s,e){  
    /* 
        特殊(奇怪的)情况 
    */  
    if(s > e){// []空数组 s=0 e=-1  
        return false;  
    } else if(s == e){// [1] 只有一个数 s=0 e=0  
        if(n == arr[s]){  
            return true;  
        } else {  
            return false;  
        }  
    }  
      
    var c = Math.floor((s+e)/2);  
    if(arr[c] == n){  
        return true;  
    } else if(n < arr[c]) {//往左边找  
        return binarySearch(arr,n,s,c - 1);  
    } else {//往右边找  
        return binarySearch(arr,n,c+1,e);  
    }  
}  
  
document.write(binarySearch(arr,11,0,arr.length - 1));  
</script>

线性——二分查找 性能对比

<script>  
var arr = [1];  
  
for(var i = 1; i < 100000; i++){  
    arr.push(arr[i-1] + Math.floor((Math.random()*5 + 1)));  
}  
  
function findInArr(arr,n){    
    for(var i = 0; i < arr.length; i++){    
        if(arr[i] == n){    
            return true;    
        }    
    }    
    return false;    
}  
  
function binarySearch(arr,n,s,e){    
    /*  
        特殊(奇怪的)情况  
    */    
    if(s > e){// 空数组 s=0 e=-1    
        return false;    
    } else if(s == e){// [1] 只有一个数 s=0 e=0    
        if(n == arr[s]){    
            return true;    
        } else {    
            return false;    
        }    
    }    
        
    var c = Math.floor((s+e)/2);    
    if(arr[c] == n){    
        return true;    
    } else if(n < arr[c]) {//往左边找    
        return binarySearch(arr,n,s,c - 1);    
    } else {//往右边找    
        return binarySearch(arr,n,c+1,e);    
    }    
}  
  
  
var start = +new Date();  
for(var i = 1; i < 1000000; i++){//1百万次循环  
      
    //var n = arr[Math.floor(Math.random()*(arr.length - 1))];  
    var n = Math.floor(Math.random()*arr[arr.length-1]);  
    findInArr(arr,n);  
    //binarySearch(arr,n,0,arr.length);  
}  
document.write(+new Date() - start);  
  
</script>

二叉树 bst：(Binary Search Tree)

<script>  
/*  
二叉树：  
1 每个根 只有2个节点   
2 左边的数小于根节点  右边的数大于根节点  
  二叉树 规则： 左边的数小于根节点  右边的数大于根节点  
{  
  value:值,  
  l:左节点  
  r:右节点   
}  
*/    
  
var root = null;  
  
//add  
function bst_add(node,n){  
    if(!root){//判断有没有根节点 没有就创建 第一次的情况下  
        root = {value:n,l:null,r:null};  
    } else if(node.value == n) {  
        //重复了不要  
        return ;  
    } else {  
        if(n < node.value){//左边  
            if(node.l){//有左节点 继续找  
                bst_add(node.l,n);  
            } else {// 没有节点  创建一个新的节点  
                node.l = {value:n,l:null,r:null};  
            }  
        } else {//左边  
            if(node.r){  
                bst_add(node.r,n);  
            } else {  
                node.r = {value:n,l:null,r:null};  
            }  
        }     
    }  
}/* end fn bst_add */  
  
//find  
function bst_find(node,n){  
    if(!root){  
        return false;  
    } else if(node.value == n){  
        return true;  
    } else {  
        if(n < node.value){// 从左边的节点找  
            if(node.l){  
                return bst_find(node.l,n);  
            } else {//没有左节点  返回false  
                return false;  
            }  
        } else {// 从右边的节点找  
            if(node.r){  
                return bst_find(node.r,n);  
            } else {//没有右节点  返回false  
                return false;  
            }  
        }     
    }  
}/* end fn bst_find */  
  
var arr = [25,34,18,7,3,30];  
bst_add(root,25);  
bst_add(root,34);  
bst_add(root,18);  
bst_add(root,7);  
bst_add(root,3);  
bst_add(root,30);  
  
console.log(root);  
  
alert(bst_find(root,15));  
  
</script>

线性 二分 二叉树 【 无序 有序 二分】性能比较

<script>  
  
var root = null;    
    
//add    
function bst_add(node,n){    
    if(!root){//判断有没有根节点 没有就创建 第一次的情况下    
        root = {value:n,l:null,r:null};    
    } else if(node.value == n) {    
        //重复了不要    
        return ;    
    } else {    
        if(n < node.value){//左边    
            if(node.l){//有左节点 继续找    
                bst_add(node.l,n);    
            } else {// 没有节点  创建一个新的节点    
                node.l = {value:n,l:null,r:null};    
            }    
        } else {//左边    
            if(node.r){    
                bst_add(node.r,n);    
            } else {    
                node.r = {value:n,l:null,r:null};    
            }    
        }       
    }    
}/* end fn bst_add */    
    
//find    
function bst_find(node,n){    
    if(!root){    
        return false;    
    } else if(node.value == n){    
        return true;    
    } else {    
        if(n < node.value){// 从左边的节点找    
            if(node.l){    
                return bst_find(node.l,n);    
            } else {//没有左节点  返回false    
                return false;    
            }    
        } else {// 从右边的节点找    
            if(node.r){    
                return bst_find(node.r,n);    
            } else {//没有右节点  返回false    
                return false;    
            }    
        }       
    }    
}/* end fn bst_find */   
  
  
  
  
//二分 查 快  
function binarySearch(arr,n,s,e){      
    /*   
        特殊(奇怪的)情况   
    */      
    if(s > e){// 空数组 s=0 e=-1      
        return false;      
    } else if(s == e){// [1] 只有一个数 s=0 e=0      
        if(n == arr[s]){      
            return true;      
        } else {      
            return false;      
        }      
    }      
          
    var c = Math.floor((s+e)/2);      
    if(arr[c] == n){      
        return true;      
    } else if(n < arr[c]) {//往左边找      
        return binarySearch(arr,n,s,c - 1);      
    } else {//往右边找      
        return binarySearch(arr,n,c+1,e);      
    }      
}  
  
////线性 增加快  
function findInArr(arr,n){    
    for(var i = 0; i < arr.length; i++){    
        if(arr[i] == n){    
            return i;//true    
        }    
    }    
    return -1;//false    
}  
  
  
var arr = [];  
//添加无序数组  
function addArr(arr,n){  
    if(findInArr(arr,n) == false){  
        arr.push(n);  
    }  
}  
  
//添加有序数组  
function addArr2(arr,n){  
    if(binarySearch(arr,n,0,arr.length - 1) == false){  
        arr.push(n);  
        arr.sort(function(n1,n2){  
            return n1 - n2;  
        });  
    }  
}  
  
//var m = 1000000; //一百万  
var m = 100000;  
var start = +new Date();  
//add  
/*for(var i = 0; i < m; i++){ 
    var n = Math.floor((Math.random()*m)); 
    //addArr(arr,n);//无序 130 
    //addArr2(arr,n);//有序 4800 00 
    //bst_add(root,n);//二叉树  100 
}*/  
  
  
  
for(var i = 0; i < m; i++){  
      
    arr.push(i);  
    //var n = Math.floor((Math.random()*m));  
    //bst_add(root,n);  
}  
var start = +new Date();  
  
// find  
for(var i = 0; i < m; i++){  
    var n = Math.floor((Math.random()*m));  
    //findInArr(arr,n);//无序 28174  
    binarySearch(arr,n,0,arr.length - 1);//有序 102  
    //bst_find(root,n);//二叉树  109  
}  
document.write(+new Date() - start);  
  
</script>

//散列——hash(哈希)

//散列 哈希 hash  
function hash_add(arr,n){

var pos = n%arr.length;

if(!arr[pos]){  
 arr[pos] = n;  
 } else {// 存在了  
 while(arr[pos]){  
 if(arr[pos] == n){  
 return ;  
 }  
 pos++;  
 if(pos == arr.length){  
 pos = 0;  
 }  
 }  
 arr[pos] = n;  
 }  
}  
var arr = [];  
arr.length = 10;

function hash_find(arr,n){  
 var pos = n%arr.length;  
 var beginIndex = pos;  
 var bLast = false;

if(!arr[pos]){// 数据不存在  
 return false;  
 } else {//有数据  
 while(arr[pos]){  
 if(bLast && beginIndex == pos) return false;

if(arr[pos] == n){  
 return true;  
 } else {// 没找到  
 pos++;  
 if(pos == arr.length){  
 pos = 0;  
 bLast = true;  
 }  
 }  
 }  
 return false;  
 }

}

hash_add(arr,25);  
hash_add(arr,35);  
hash_add(arr,28);  
hash_add(arr,37);  
hash_add(arr,4);  
hash_add(arr,16);  
hash_add(arr,5);  
hash_add(arr,3);  
hash_add(arr,1);  
hash_add(arr,2);

document.write(arr);  
document.write(hash_find(arr,5));

var arr = [];  
arr.length = 10;

function hash_add(arr,n){  
 //位置：  
 var pos = n%arr.length;  
 var beginIndex = pos;  
 var bEnd = false;

if(!arr[pos]){//没有  
 arr[pos] = n;  
 } else {//有值  
 while(arr[pos]){

//判断  
 if(bEnd == true && beginIndex == pos){  
 return;  
 }

if(arr[pos] == n){  
 return;//有重复数据  
 }  
 pos++;  
 if(pos == arr.length){  
 pos = 0;  
 bEnd = true;  
 }  
 }

arr[pos] = n;  
 }

}

hash_add(arr,12);  
hash_add(arr,5);  
hash_add(arr,55);  
hash_add(arr,555);  
hash_add(arr,102);  
hash_add(arr,18);  
hash_add(arr,19);  
hash_add(arr,35);  
hash_add(arr,1);  
hash_add(arr,2);  
hash_add(arr,3);

document.write(arr + "<br />");

function hash_find(arr,n){

var pos = n%arr.length;  
 var beginIndex = pos;  
 var bEnd = false;  
 if(!arr[pos]){  
 return false;  
 } else {

while(arr[pos]){  
 if(bEnd && beginIndex == pos){  
 return false;  
 }

if(arr[pos] == n){  
 return true;  
 }  
 pos++;

if(pos == arr.length){  
 pos = 0;  
 bEnd = true;  
 }  
 }  
 return false;  
 }  
}

document.write(hash_find(arr,17));

</script>
