class Leetcode.이재훈.이재훈.Solution:
    def maxSatisfaction(self, satisfaction: list[int]) -> int:
        # n 개 dishes
        # like-time coefficient : time[i] * satisfaction[i]
        # dish 삭제하여 최대

        satisfaction.sort()

        start = 0
        result = 0
        while start != len(satisfaction):
            sum_satis = 0
            time=1
            for i in range(start, len(satisfaction)):
                sum_satis += time * satisfaction[i]
                time+=1
            

            print(f"sum_satis : {sum_satis}")
            result = max(result, sum_satis)
            print(f"result : {sum_satis}")

            start += 1
        
        return result


if __name__ == "__main__":
    sol = Leetcode.이재훈.이재훈.Solution()
    print(sol.maxSatisfaction([-1, -8, 0, 5, -9]))
    print(sol.maxSatisfaction([4,3,2]))
    print(sol.maxSatisfaction([-1,-4,-5]))
