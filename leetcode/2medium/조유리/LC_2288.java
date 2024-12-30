class LC_2288 {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++){
            String word = words[i];
            // 시작은 $ 이고, 나머지는 다 숫자인 경우
            boolean flag = true;
            if(word.charAt(0) != '$') flag = false;
            for(int j=1; j<word.length(); j++){
                if(!Character.isDigit(word.charAt(j))){
                    flag = false;
                    break;
                }
            }

            if(flag && word.length() > 1){
                long price = Long.parseLong(word.substring(1));
                //System.out.println(price);
                double number = price * ((100 - discount) / 100.0);
                //System.out.println(number);

                String formattNum = String.format("%.2f", number);
                words[i] = "$"+formattNum;
            }
        }

        return String.join(" ", words);
    }
}