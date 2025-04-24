class Solution:
    def countMatches(self, items: list[list[str]], ruleKey: str, ruleValue: str) -> int:
        result = 0

        if ruleKey == "type":
            index = 0
        elif ruleKey == "color":
            index = 1
        else :
            index = 2

        for item in items:
            if item[index] == ruleValue:
                result += 1
        
        return result