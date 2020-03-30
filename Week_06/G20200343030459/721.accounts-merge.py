#
# @lc app=leetcode id=721 lang=python3
#
# [721] Accounts Merge
#
# https://leetcode.com/problems/accounts-merge/description/
#
# algorithms
# Medium (45.44%)
# Likes:    1062
# Dislikes: 255
# Total Accepted:    62.3K
# Total Submissions: 135.7K
# Testcase Example:  '[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]'
#
# Given a list accounts, each element accounts[i] is a list of strings, where
# the first element accounts[i][0] is a name, and the rest of the elements are
# emails representing emails of the account.
# 
# Now, we would like to merge these accounts.  Two accounts definitely belong
# to the same person if there is some email that is common to both accounts.
# Note that even if two accounts have the same name, they may belong to
# different people as people could have the same name.  A person can have any
# number of accounts initially, but all of their accounts definitely have the
# same name.
# 
# After merging the accounts, return the accounts in the following format: the
# first element of each account is the name, and the rest of the elements are
# emails in sorted order.  The accounts themselves can be returned in any
# order.
# 
# Example 1:
# 
# Input: 
# accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
# "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
# "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
# Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
# 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary",
# "mary@mail.com"]]
# Explanation: 
# The first and third John's are the same person as they have the common email
# "johnsmith@mail.com".
# The second John and Mary are different people as none of their email
# addresses are used by other accounts.
# We could return these lists in any order, for example the answer [['Mary',
# 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
# ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
# would still be accepted.
# 
# 
# 
# Note:
# The length of accounts will be in the range [1, 1000].
# The length of accounts[i] will be in the range [1, 10].
# The length of accounts[i][j] will be in the range [1, 30].
# 
#

# @lc code=start
from collections import defaultdict
class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        self.father = [i for i in range(len(accounts))]
        email_to_ids = self.get_email_to_id(accounts)

        for email, user_ids in email_to_ids.items():
            root_id = user_ids[0]
            for user_id in user_ids[1:]:
                self.union(root_id, user_id)
        
        id_to_email_set = self.get_id_to_email_set(accounts)

        result = []
        for user_id, emails in id_to_email_set.items():
            name = accounts[user_id][0]
            result.append([
                name,
                *sorted(emails)
            ])

        return result

    def get_id_to_email_set(self, accounts):
        id_to_email_set = {}
        for user_id, account in enumerate(accounts):
            root_id = self.find(user_id)
            email_set = id_to_email_set.get(root_id, set())
            for email in account[1:]:
                email_set.add(email)
            id_to_email_set[root_id] = email_set
            
        return id_to_email_set

    def get_email_to_id(self, accounts):
        email_to_ids = defaultdict(list)
        for user_id, account in enumerate(accounts):
            for email in account[1:]:
                email_to_ids[email].append(user_id)
        return email_to_ids

    def union(self, a, b):
        self.father[self.find(b)] = self.find(a)

    def find(self, node):
        root = node
        while self.father[root] != root:
            root = self.father[root]
        while self.father[node] != node:
            temp = node
            node = self.father[node]
            self.father[temp] = root
        return root
        

        
# @lc code=end

