import java.util.*;

class Solution {
    // dfs -> 매 선택마다 4가지 경우 (왼쪽 카드를 코인을 사용해 갖거나, 오른쪽 카드를 코인을 사용해 갖거나, 둘다 갖거나, 둘 다 갖지 않는 경우)
    // 999개 -> 666개 남음 (최대 4^333 경우의 수 ) -> dfs는 안될 거 같다.
    
    // 뽑지 않았던 카드를 저장해두고, 숫자를 만들 수 없을 때 코인이 있다면 뽑지 않았던 카드 중에서 카드 뽑아 코인 소모하는 식으로 구현하면 되지 않을까?
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        
        List<Integer> mycards = new ArrayList<>();
        for (int i = 0; i < n / 3; ++i) {
            mycards.add(cards[i]);
        }
                
        return ans;
    }
}
