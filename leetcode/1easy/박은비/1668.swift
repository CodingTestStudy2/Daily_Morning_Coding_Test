class Leetcode.이재훈.Solution {
    func maxRepeating(_ sequence: String, _ word: String) -> Int {
        
        let sequence = Array(sequence)
        let word = Array(word)

        var maxSubstringsCount = 0
        
        var i = 0

        while i<=sequence.count-word.count {
            guard sequence[i] == word[0] else {
                i += 1
                continue
            }

            var substringsCount = 0
            var j = i
            while j<=sequence.count-word.count && Array(sequence[j..<j+word.count]) == word {
                j += word.count
                substringsCount += 1
            }
            i += 1
            maxSubstringsCount = max(maxSubstringsCount, substringsCount)
        }

        return maxSubstringsCount

    }
}
