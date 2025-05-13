class Solution:
    def minCutCost(self, m: int, n: int, horizontalCut: list[int], verticalCut: list[int]) -> int:
        horizontalCut.sort(reverse=True)
        verticalCut.sort(reverse=True)

        h_idx, v_idx = 0, 0
        total_cost = 0
        current_count = 1
        total_pieces = 0
        last_direction = None

        while total_pieces < (m * n) - 1:
            is_horizontal = False
            if h_idx < len(horizontalCut) and (v_idx >= len(verticalCut) or horizontalCut[h_idx] >= verticalCut[v_idx]):
                is_horizontal = True

            if is_horizontal:
                cost = horizontalCut[h_idx]
                h_idx += 1
                current_direction = 'h'
            else:
                cost = verticalCut[v_idx]
                v_idx += 1
                current_direction = 'v'

            if current_direction != last_direction and last_direction is not None:
                current_count += 1

   
            if total_pieces + current_count > (m * n) - 1:
                current_count = (m * n) - 1 - total_pieces


            total_cost += cost * current_count
            total_pieces += current_count
            last_direction = current_direction

        return total_cost
