<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def dayOfYear(self, date: str) -> int:
        result = 0
        year, month, day = map(int, date.split("-"))

        for i in range(1, month):
            result += self.checkDays(year, i)
        result += day

        return result

    def checkDays(self, year:int, month: int) -> int:
        days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

        if month == 2 and year == 1900:
            return days[month-1]
        if month == 2 and self.isLeapYear(year):
            return 29
        else:
            return days[month-1]

    def isLeapYear(self, year) -> bool:
        if year % 4 == 0:
            return True
        else:
            return False
