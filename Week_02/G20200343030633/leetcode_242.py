def isAnagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    l = {}
    for i in range(len(s)):
        j1 = ord(s[i]) - ord('a')
        j2 = ord(t[i]) - ord('a')
        l[j1] = l.get(j1, 0) + 1
        l[j2] = l.get(j2, 0) - 1
    print(l)
    for val in l.values():
        if val != 0:
            return False
    return True


# return abs(sum([ord(x)**0.5 for x in s])-sum([ord(y)**0.5 for y in t]))<1e-5
s = "axncxlhjle"

t = "xxconlaelh"

print(isAnagram(s, t))



