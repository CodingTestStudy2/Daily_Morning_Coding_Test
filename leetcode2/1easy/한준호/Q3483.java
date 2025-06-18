package Leetcode.한준호;

class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<digits.length; i++){
            for(int j = i+1; j<digits.length; j++){
                for(int k = j+1; k<digits.length; k++){
                    if(digits[i]%2==0){
                        if(digits[k]*100 + digits[j]*10 + digits[i] >= 100) set.add(digits[k]*100 + digits[j]*10 + digits[i]);
                        if(digits[j]*100 + digits[k]*10 + digits[i] >= 100) set.add(digits[j]*100 + digits[k]*10 + digits[i]);

                    }
                    if(digits[j]%2==0){
                        if(digits[i]*100 + digits[k]*10 + digits[j] >= 100) set.add(digits[i]*100 + digits[k]*10 + digits[j]);
                        if(digits[k]*100 + digits[i]*10 + digits[j] >= 100) set.add(digits[k]*100 + digits[i]*10 + digits[j]);

                    }
                    if(digits[k]%2==0){
                        if(digits[i]*100 + digits[j]*10 + digits[k] >= 100) set.add(digits[i]*100 + digits[j]*10 + digits[k]);
                        if(digits[j]*100 + digits[i]*10 + digits[k] >= 100) set.add(digits[j]*100 + digits[i]*10 + digits[k]);

                    }
                }
            }
        }
        for(int i : set){
            System.out.println(i);
        }
        return set.size();
    }


}