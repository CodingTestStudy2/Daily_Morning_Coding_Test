class Solution:
    def minimumRounds(self, tasks: list[int]) -> int:
        key_tasks = {}

        for task in tasks:
            if not task in key_tasks:
                key_tasks[task] = 1
                continue
            key_tasks[task] += 1
        
        # 브루트 포스
        key_list = key_tasks.keys()
        # print(f"key_list : {key_list}")
        result = 0

        for key in key_list:
            # print(f"key : {key_tasks[key]}")
            while key_tasks[key] > 1:
                if key_tasks[key] == 4:
                    key_tasks[key] -= 4
                    result += 2
                elif key_tasks[key] >= 3:
                    key_tasks[key] -= 3
                    result += 1
                else:
                    key_tasks[key] -= 2
                    result += 1
            
            if key_tasks[key] == 1:
                result = -1
                break
        
        return result
    
    # def recur(self, value:int) -> bool:

if __name__ == "__main__":
    sol = Solution()
    print(sol.minimumRounds([5,5,5,5]))

    print(sol.minimumRounds([2, 3, 3]))
    print(sol.minimumRounds([2,2,3,3,2,4,4,4,4,4]))