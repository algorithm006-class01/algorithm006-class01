"""
    一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
    假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
    例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
    与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

    现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
    请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

    注意:
        起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
        所有的目标基因序列必须是合法的。
        假定起始基因序列与目标基因序列是不一样的。

    示例 1:
        start: "AACCGGTT"
        end:   "AACCGGTA"
        bank: ["AACCGGTA"]
        返回值: 1

    示例 2:
        start: "AACCGGTT"
        end:   "AAACGGTA"
        bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
        返回值: 2

    示例 3:
    start: "AAAAACCC"
    end:   "AACCCCCC"
    bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
    返回值: 3
"""
from typing import List


class Solution:
    MAPPING = {
        "A": "GCT",
        "G": "ACT",
        "C": "AGT",
        "T": "AGC",
    }

    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        return self.two_end_bfs(start, end, bank)

    @classmethod
    def two_end_bfs(cls, start: str, end: str, bank: List[str]) -> int:
        if end and end in bank:
            start_len = len(start)
            start_queue = [start]
            end_queue = [end]
            visit = {}

            res = 0
            while start_queue:
                res += 1
                tmp_queue = []
                for tmp_info in start_queue:
                    for i in range(start_len):
                        for char in cls.MAPPING[tmp_info[i]]:
                            check_info = tmp_info[:i] + char + tmp_info[i + 1:]

                            if check_info not in bank:
                                continue

                            if check_info in end_queue:
                                return res

                            if check_info not in visit:
                                visit[check_info] = True
                                tmp_queue.append(check_info)
                start_queue = tmp_queue
                if len(start_queue)> len(end_queue):
                    start_queue, end_queue = end_queue, start_queue
        return -1

    @classmethod
    def bfs(cls, start: str, end: str, bank: List[str]) -> int:
        if end and end in bank:
            queue = [start]
            start_len = len(start)
            visit = {}

            res = 0
            while queue:
                tmp_queue = []
                res += 1
                for cur_start in queue:
                    for i in range(start_len):
                        for tmp_char in cls.MAPPING[cur_start[i]]:
                            check_start = cur_start[:i] + tmp_char + cur_start[i + 1:]
                            if check_start not in bank:
                                continue

                            if check_start == end:
                                return res

                            if check_start not in visit:
                                visit[check_start] = 1
                                tmp_queue.append(check_start)
                queue = tmp_queue
        return -1


if __name__ == '__main__':
    start = "AACCTTGG"
    end = "AATTCCGG"
    bank = ["AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"]
    print(Solution.bfs(start, end, bank))
