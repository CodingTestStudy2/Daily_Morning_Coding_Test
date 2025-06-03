class Leetcode.이재훈.Solution {
    @_optimize(speed)
    func findPeakGrid(_ mat: [[Int]]) -> [Int] {
        let m = mat.count
        let n = mat[0].count
        let dx = [0, 1, 0, -1]
        let dy = [-1, 0, 1, 0]
        
        for i in 0..<m {
            for j in 0..<n {
                var isPeak = true
                
                for k in 0..<4 {
                    let newX = i + dx[k]
                    let newY = j + dy[k]
                    
                    if 0 <= newX && newX < m && 0 <= newY && newY < n {
                        if mat[newX][newY] >= mat[i][j] {
                            isPeak = false
                            break
                        }
                    }
                }
                
                if isPeak {
                    return [i, j]
                }
            }
        }
        
        return []
    }
}
