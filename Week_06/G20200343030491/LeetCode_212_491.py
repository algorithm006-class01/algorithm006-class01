def findWords(board,words):
    if not board or not board[0]:return []
    if not words: return []
    
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    m = len(board)
    n = len(board[0])
    root = {}
    end_of_word = '#'
    ans = set()

    # insert each word
    for word in words:
        node = root
        for char in word:
            node = node.setdefault(char,{})
        node[end_of_word] = end_of_word

    # search a word
    def _search(word):
        node = root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return end_of_word in node

    # search a prefix:
    def _startWith(prefix):
        node = root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True

    def dfs(board,x,y,curWord,curDict):
        print(x,y,curWord,curDict)
        # pass
        curWord += board[x][y]
        curDict = curDict[board[x][y]]

        if end_of_word in curDict:
            ans.add(curWord)
        temp, board[x][y] = board[x][y], '@'
        for i in range(len(dx)):
            if 0<=x+dx[i]<m and 0<=y+dy[i]<n and board[x+dx[i]][y+dy[i]] != '@' and board[x+dx[i]][y+dy[i]] in curDict:
                dfs(board, x+dx[i],y+dy[i],curWord, curDict)

        board[x][y] = temp 

    print(root)

    for i in range(m):
        for j in range(n):
            if board[i][j] in root:
                dfs(board,i,j,'',root)
    print('ans:',ans)
    return ans


def findWords(board, words):
        if not board or not board[0]:
            return []
        
        m = len(board)
        n = len(board[0])
        trie = {}
        res = set()
        
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char,{})
            node['#'] = True
            
        def dfs(i,j,node,pre,visited):
            if '#' in node:
                res.add(pre)
                
            for (dx, dy) in ((-1,0), (0,-1), (1,0), (0,1)):
                if 0<=i+dx<m and 0<=j+dy<n and board[i+dx][j+dy] in node and (i+dx,j+dy) not in visited:
                    dfs(i+dx,j+dy,node[board[i+dx][j+dy]],pre+board[i+dx][j+dy], visited | {(i+dx,j+dy)})
                    
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    dfs(i, j, trie[board[i][j]], board[i][j],{(i,j)})
                        
        print(list(res))
