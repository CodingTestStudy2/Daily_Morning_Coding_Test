from collections import defaultdict, deque
class Solution:
    def minimumCost(self, n: int, edges: List[List[int]], query: List[List[int]]) -> List[int]:

        dic = defaultdict(list)
        dicvalue = defaultdict(list)

        for a, b, c in edges:
            dic[a].append(b)
            dic[b].append(a)
            dicvalue[min(a, b), max(a,b)].append(c)
        
        db = defaultdict(int)
        keylist = dic.keys()
        check = set()

        def find(v, r):

            for j in dic[v]:
                if not j in check:
                    for i in dicvalue[j]:
                        
                    r = r & find()

        for i in keylist:
            if not i in check:
                queu = deque()
                queu.append(i)
                current = []
                current.append(i)
                check.add(i)
                while(queu):
                    cur = queu.pop()

                    for j in dic[i]:
                        if not j in check:
                            




        result = []
        for a, b in query:
            c = (min(a, b), max(a, b))
            if c in db:
                result.append(db[c])
            else:
                result.append(-1)

        return result