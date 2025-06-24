class Solution {
    public String generateTag(String caption) {
        String result = "#";
        String[] wordArray = caption.split(" ");


        for (int i = 0; i < wordArray.length; i++) {
            String new_word = "";
            String word = wordArray[i];
            word = word.replaceAll(" ", "");

            if (word == "") {
                System.out.println("continue");
                continue;
            }
            System.out.println("word : " + word);

            if (result == "#") {
                System.out.println("i : " + i);
                new_word = word.toLowerCase();
            } else {
                System.out.println("i : " + i);
                new_word = new_word.concat(word.substring(0, 1).toUpperCase());
                new_word = new_word.concat(word.substring(1, word.length()).toLowerCase());
            }

            System.out.println(new_word);

            result = result.concat(new_word);

            if (result.length() >= 100) {
                result = result.substring(0, 100);
            }
        }

        return result;
    }
}