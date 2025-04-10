class Solution:
    def removeAnagrams(self, words: list[str]) -> list[str]:
        for i in range(len(words)-1, 0, -1):
            if self.checkAnagrams(words[i], words[i-1]):
                del words[i]

        return words
    
    def checkAnagrams(self, word1, word2) -> bool:
        word1_list = list(word1)
        word2_list = list(word2)

        if sorted(word1_list) == sorted(word2_list):
            return True
        return False


if __name__ == "__main__":
    sol = Solution()

    print(sol.removeAnagrams(["abba","baba","bbaa","cd","cd"]))
    print(sol.removeAnagrams(["a","b","c","d","e"]))
    print(sol.removeAnagrams(["az", "azz"]))