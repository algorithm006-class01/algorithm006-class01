# 遍历，压入map,以异位词的字母元组座位key,关键就在这个key，只要找到一种办法让每组异位词的key对应到一个key即可
def groupAnagrams(strs):
    result = {}
    for s in strs:
        key = tuple(sorted(s))
        if key in result:
            result.get(key).append(s)
        else:
            result[key] = [s]

    return result.values()

strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

result = groupAnagrams(strs)

print(result)