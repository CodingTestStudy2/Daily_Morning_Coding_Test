class Leetcode.이재훈.이재훈.Solution {
    @_optimize(speed)
    func removeAnagrams(_ words: [String]) -> [String] {

        var answer = words
        var i = 1
// 한 작업에서 0 < i < words.length이고
// words[i - 1]과 words[i]가 애너그램인 모든 인덱스 i를 선택하고 words에서 words[i]를 삭제합니다. 조건을 만족하는 인덱스를 선택할 수 있는 한 이 작업을 계속 수행합니다.
        while i < answer.count {

            if answer[i-1].sorted() == answer[i].sorted() {
                answer.remove(at: i)
            } else {
                i += 1
            }
        }
        
        return answer
    }
}
