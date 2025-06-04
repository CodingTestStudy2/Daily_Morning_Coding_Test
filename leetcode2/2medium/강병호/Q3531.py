
# x 같은 것들

class Leetcode.이재훈.이재훈.Solution:
    def countCoveredBuildings(self, n: int, buildings: list[list[int]]) -> int:
        answer = 0

        xLocList= dict()
        yLocList= dict()
        xLocTuple = dict()
        yLocTuple = dict()
        # 1. buildings 순회해서 x 리스트 뽑기
        for building in buildings:
            x = building[0]
            y = building[1]
            
            # 튜플 뽑기 -> (first, last)
            if x not in xLocList:
                xLocList[x] = []
            xLocList[x].append(building)
        
            if y not in yLocList:
                yLocList[y] = []
            yLocList[y].append(building)


        # 2. sort
        for xloc in xLocList:
            xLocList[xloc].sort(key = lambda x : x[1])
            xLocTuple[xloc] = (xLocList[xloc][0][0], xLocList[xloc][-1][0])

        for yloc in yLocList:
            yLocList[yloc].sort(key = lambda y : y[0])
            # print(f"yLocList[yloc][0], : {yLocList[yloc][0]}")
            yLocTuple[yloc] = (yLocList[yloc][0][1], yLocList[yloc][-1][1])
        
        print(f"xLocTuple : {xLocTuple}")
        print(f"yLocTuple : {yLocTuple}")

        for building in buildings:
            # print(f"building : {building}")
            # x_index = xLocList[building[0]].index(building)
            # y_index = yLocList[building[1]].index(building)
            # max_x_index = len(xLocList[building[0]])
            # max_y_index = len(yLocList[building[1]])
            # print(f"x : {x_index}, y : {y_index}")
            x = building[0]
            y = building[1]
            first_x = xLocTuple[building[0]][0]
            last_x = xLocTuple[building[0]][1]
            first_y = yLocTuple[building[1]][0]
            last_y = yLocTuple[building[1]][1]

            print(f"first_x : {first_x}, last_s : {last_x}, first_y : {first_y}, last_y : {last_y}")
            
            if first_x < x < last_x and first_y < y < last_y:
                answer+=1
                continue

        return answer
            

if __name__ == "__main__":
    sol = Leetcode.이재훈.이재훈.Solution()
    # print(sol.countCoveredBuildings(3, [[1,2],[2,2],[3,2],[2,1],[2,3]]))
    print(sol.countCoveredBuildings(3, [[1,1],[1,2],[2,1],[2,2]]))
    print(sol.countCoveredBuildings(5, [[1,3],[3,2],[3,3],[3,5],[5,3]]))