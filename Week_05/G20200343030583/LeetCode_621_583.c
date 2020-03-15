/*
 * @lc app=leetcode id=621 lang=c
 *
 * [621] Task Scheduler
 * https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
 * can also use priority queue to solve this problem, please refer to the solution,
 * second one: https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space
 */

// @lc code=start
#include<stdio.h>

int leastInterval(char* tasks, int tasksSize, int n){
    int counter[26] ={0};
    int i,max=0,maxCount;
    for(i=0;i<tasksSize;i++){
        counter[tasks[i] - 'A']++;
        // count the number of tasks with the same maximum number
        if(max == counter[tasks[i] - 'A']){
            maxCount++;
        }
        if(max < counter[tasks[i] - 'A']){
            max = counter[tasks[i] - 'A'];
            maxCount = 1;
        }
    }
    int emptySlot = (max - 1) * (n - (maxCount - 1));
    int avaiableTask = tasksSize - max * maxCount;
    int idleSlot = emptySlot - avaiableTask > 0? emptySlot - avaiableTask:0;

    return tasksSize + idleSlot;

}

// devide into chunk and consider the number of tasks in each chunk
// insert less frequent tasks into the chunk
// Note that #most frequent tasks decides the #chunks, 
// #chunks = #most frequent tasks - 1
// n+1 is chunk size
// remember need to add #most frequent tasks in the end to finish them in cpu
int leastInterval(char* tasks, int tasksSize, int n){
    int counter[26] ={0};
    int i,max=0,maxCount;
    for(i=0;i<tasksSize;i++){
        counter[tasks[i] - 'A']++;
        // count the number of tasks with the same maximum number
        if(max == counter[tasks[i] - 'A']){
            maxCount++;
        }
        if(max < counter[tasks[i] - 'A']){
            max = counter[tasks[i] - 'A'];
            maxCount = 1;
        }
    }
    // frameSize = #tasks per chunk * #chunks + frame(maxCount here)
    int frameSize = (n+1) * (max - 1) + maxCount;
    return tasksSize > frameSize ? tasksSize : frameSize;

}

// @lc code=end

