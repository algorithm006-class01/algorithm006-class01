from collections import Counter
def leastInterval(tasks, n):
    if len(tasks)<=1: return len(tasks)
    dic = Counter(tasks)
    dic = dic.most_common()
    rows = dic[0][1]
    cols = n + 1
    res = (rows-1) * cols

    for task in dic:
        if task[1] == rows:
            res += 1
    print(res)
    return res if res>len(tasks) else len(tasks)

leastInterval(["A","A","A","B","B","B"],2)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if len(tasks)<=1: return len(tasks)
        array = [0]*26
        for task in tasks:
            array[ord(task)-ord('A')] += 1
        array.sort()
        time = 0
        while array[-1] > 0:
            for i in range(n+1):
                if array[-1] == 0: break
                elif i<26 and array[26-i-1]>0:
                    array[25-i] -= 1
                time += 1
            array.sort()
            
        return time