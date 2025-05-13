import string

class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        preorder_list = list(map(str, preorder.split(",")))
        print(preorder_list)

        node_count = 1

        # 숫자면 최대 2개의 노드 생성 가능
        for data in preorder_list:
            node_count -= 1 # null이든 숫자든 하나 사용

            if node_count < 0:
                return False

            if data != '#': # 숫자면 2개 노드 생성가능
                node_count += 2
        
        if node_count == 0:
            return True
        else:
            return False

            




if __name__ == "__main__":
    sol = Solution()
    sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")