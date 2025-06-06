class Leetcode.이재훈.이재훈.Solution:
    answer = 0
    def dayOfYear(self, date: str) -> int:
        month_date = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        year, month, day = map(int, date.split('-'))

        if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
            month_date[1] = 29 

        answer = sum(month_date[0:month - 1]) + day
        
        return answer
