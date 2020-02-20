学习笔记
# 树
# 二叉树
# 二叉搜索树
# 图
# 红黑树

# 递归
## 盗梦空间
   - 模板
      ```java
      public void recur(int lever,int param) {
        // terminator
        if(leverl > max_level){
            // process result
            return;
        }
        //process current logic
        process(level,param);
        
        //drill down
        recur(level:level+1,newParam);
        
        //restore current status
      }
      ```
   - 注意
     1. 抵制人肉递归
     2. 找最近重复性
     3. 数学归纳法思维
