class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
      
        g.sort(reverse=True)
        s.sort(reverse=True)
        counter = 0
        
        while g and s:
            if s[-1]>=g[-1]:
                counter += 1
                g.pop()
                s.pop()
            else:
                s.pop()
                    
        return counter