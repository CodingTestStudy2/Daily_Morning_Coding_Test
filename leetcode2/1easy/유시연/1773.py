class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        n = len(items)
        count = 0
        if ruleKey == 'type':
            for i in range(n):
                if items[i][0] == ruleValue:
                    count += 1

        if ruleKey == 'color':
            for i in range(n):
                if items[i][1] == ruleValue:
                    count += 1

        if ruleKey == 'name':
            for i in range(n):
                if items[i][2] == ruleValue:
                    count += 1

        return count