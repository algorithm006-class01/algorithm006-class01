"""
    给定一个用字符数组表示的 CPU 需要执行的任务列表。
    其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
    任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
    CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
    然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

    你需要计算完成所有任务所需要的最短时间。

    示例 1：
        输入: tasks = ["A","A","A","B","B","B"], n = 2
        输出: 8
        执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.

    注：
        任务的总个数为 [1, 10000]。
        n 的取值范围为 [0, 100]。
"""
from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        pass

    @classmethod
    def use_sort(cls, tasks: List[str], n: int) -> int:
        # 如果没有任务 或者  单位时间为0 ，则返回任务的个数
        if not tasks or not n:
            return len(tasks)

        # 将任务按个数划分  得到task_counts key是task value是task的个数
        task_counts = dict()
        for task in tasks:
            task_counts[task] = task_counts.get(task, 0) + 1

        # 这个返回的是一个列表 里面的元素是元祖格式 第一个元素是任务名称 第二个元素是任务出现的次数
        task_counts = sorted(task_counts.items(), key=lambda i: i[1], reverse=True)
