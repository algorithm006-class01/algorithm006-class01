class Solution:
    def __init__(self):
        self.res = 0
    def compare(self, str1,str2):
        counter = 0
        for i in range(len(str1)):
            if str1[i] != str2[i]:
                counter += 1

        if counter==1:
            return True
        else:
            return False
        
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if not bank:
            return -1
        
        def rec(_start, _bank, k):
            if _start == end:
                self.res = k
            for i in range(len(_bank)):
                if self.compare(_start, _bank[i]):
                    rec(_bank[i],_bank[:i]+_bank[i+1:],k+1)
                    
        rec(start, bank, 0)
        
        return self.res if self.res != 0 else -1

class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        q = deque([(start,0)])
        bank = set(bank)
        visited = set()

        while q:

            word, lev = q.popleft()
            if word == end:
                return lev

            for char in 'ACGT':
                for i in range(len(word)):
                    newWord = word[:i] + char + word[i+1:]

                    if newWord in bank and newWord not in visited:
                        q.append((newWord,lev+1))
                        visited.add(newWord)

        return -1

class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        size = len(start)
        general_dic = defaultdict(list)

        for gene in bank:
            for i in range(size):
                general_dic[gene[:i]+'*'+gene[i+1:]].append(gene)

        visited = set([start])
        q = deque()
        q.append((start,0))
        while q:
            cur, lev = q.popleft()
            for i in range(size):
                for distanceOne in general_dic[cur[:i]+'*'+cur[i+1:]]:
                    if end == distanceOne:
                        return lev+1
                    else:
                        if distanceOne not in visited:
                            visited.add(distanceOne)
                            q.append((distanceOne, lev+1))
                            
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if end not in bank: return -1
        beginD =  {start}
        endD = {end}
        step = 0
        bank = set(bank)
        geneLen = len(start)

        while beginD:
            nextD = set()
            step += 1
            for gene in beginD:
                for i in range(geneLen):
                    for g in 'ACGT':
                        if g != gene[i]:
                            newGene = gene[:i]+g+gene[i+1:]
                            if newGene in endD:
                                return step 
                            if newGene in bank:
                                nextD.add(newGene)
                                bank.remove(newGene)
            beginD = nextD
            if len(endD)<len(beginD):
                beginD, endD = endD, beginD

        return -1