def remove_anagrams(words):
    changed = True
    while changed:
        changed = False
        for i in range(len(words) - 1, 0, -1): 
            if len(words[i]) == len(words[i - 1]) and sorted(words[i]) == sorted(words[i - 1]):
                del words[i] 
                changed = True
                break  
    return words
