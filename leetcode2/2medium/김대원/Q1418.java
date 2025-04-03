// 1. 아이디어 : 음식 이름으로 정렬 후 테이블과 일치하도록 메뉴 갯수 카운팅
// 2. 시간복잡도 : O(N * logN)
// 3. 자료구조/알고리즘 : 구현

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> table = new HashMap<>();
        List<String> menus = new ArrayList<>();
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            String menu = order.get(2);

            if (!menus.contains(menu)) menus.add(menu);

            if (!table.containsKey(tableNum)) {
                Map<String, Integer> tmp = new HashMap<>();
                tmp.put(menu, 1);

                table.put(tableNum, tmp);
            } else {
                Map<String, Integer> tmp = table.get(tableNum);
                tmp.put(menu, tmp.getOrDefault(menu, 0) + 1);
            }
        }

        Collections.sort(menus);
        List<Integer> tableNums = new ArrayList<>(table.keySet());
        Collections.sort(tableNums);

        List<List<String>> answer = new ArrayList<>();
        for (int tNum : tableNums) {
            List<String> result = new ArrayList<>();
            result.add(String.valueOf(tNum));

            Map<String, Integer> tableInfo = table.get(tNum);
            for (String menu : menus) {
                if (tableInfo.get(menu) == null) {
                    result.add("0");
                } else {
                    result.add(String.valueOf(tableInfo.get(menu)));
                }
            }

            answer.add(result);
            System.out.println(result);
        }

        menus.add(0, "Table");
        answer.add(0, menus);

        return answer;
    }
}