class Solution:
    def categorizeBox(self, length: int, width: int, height: int, mass: int) -> str:
        return "Both" if (length >= 10000 or width >= 10000 or height >= 10000 or length * width * height >= 10**9) and mass >= 100 else "Bulky" if (length >= 10000 or width >= 10000 or height >= 10000 or length * width * height >= 10**9) else "Heavy" if mass >= 100 else "Neither"
