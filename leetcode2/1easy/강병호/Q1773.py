<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
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