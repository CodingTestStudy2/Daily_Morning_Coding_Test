# Apply Discount to Prices

class Leetcode.이재훈.이재훈.Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        answer = []
        for s in sentence.split(' '):
            # print(s[0].isdigit())
            if s[0] != '$':
                answer.append(s)
            else:
                if s[1:].isdigit():
                    c_num = int(s[1:])
                    tmp = '$'
                    d = str(c_num*(100-discount)/100)
                    if d[-2] == '.' and d[-1].isdigit():
                        d += '0'
                    answer.append(tmp+d)
                else:
                    # print(s[1:])
                    answer.append(s)

        return ' '.join(answer)