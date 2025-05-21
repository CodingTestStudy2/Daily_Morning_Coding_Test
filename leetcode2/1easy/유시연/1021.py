def removeOuterParentheses(s: str) -> str:
    result = []
    leng = 0
    
    for char in s:
        if char == '(':
            if leng > 0:
                result.append(char)
            leng += 1
        else: 
            leng -= 1
            if leng > 0:
                result.append(char)
    
    return ''.join(result)
