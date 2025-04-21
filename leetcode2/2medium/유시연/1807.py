class Solution:
    def evaluate(self, s: str, knowledge: List[List[str]]) -> str:
        knowledge_dict = {}

        for key, value in knowledge:
            knowledge_dict[key] = value

        result = []
        i = 0
        
        while i < len(s):
            if s[i] == '(':
   
                j = i + 1
                while s[j] != ')':
                    j += 1
                
                key = s[i+1:j]
           
                value = knowledge_dict.get(key, '?')
                result.append(value)
                i = j + 1  
            else:
                result.append(s[i])
                i += 1

        return ''.join(result)