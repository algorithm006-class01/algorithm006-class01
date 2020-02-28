学习笔记
# 分治
   - 代码模板
   ```java
      public void divide_cpnquer(int lever,int[] param) {
        // terminator
        if(leverl > max_level){
            // process result
            return;
        }
        // prepare data
        int num1=prepare_data(parm)
        // divide
        int []sub_problems = split_problem(param,num1)
        // cpnquer subproblems
        
        int sub_result1 = diver_conquer(sub_problems[0]);
        int sub_result2 = diver_conquer(sub_problems[1]);
        int sub_result3 = diver_conquer(sub_problems[2]);
        
        //process and generate the final result
        result = process_result(sub_result1,sub_result2,sub_result3)
        
        //restore current status
      }
   ``` 
# 回溯ddd   