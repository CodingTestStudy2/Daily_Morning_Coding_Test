class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        stack = []
        result = []

        for c in s:
            if c == '(':
                if stack: # 스택이 비어있지 않으면 last아님
                    result.append(c)
                stack.append(c)
            else:
                stack.pop()
                if stack : # 스택이 비어있지 않으면 last아님
                    result.append(c)
        return ''.join(result)