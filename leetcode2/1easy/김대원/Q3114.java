class Solution {
  public String findLatestTime(String s) {
    char[] chars = s.toCharArray();
    String result = "";
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ':') {
        result += chars[i];
        continue;
      }

      if (i == 0 && chars[i] == '?') {
        if (chars[i + 1] == '?' || chars[i + 1] - 48 <= 1) {
          result += "1";
        } else {
          result += "0";
        }
      } else if (i == 1 && chars[i] == '?') {
        if (result.charAt(0) - 48 == 0) {
          result += "9";
        } else {
          result += "1";
        }
      } else if(i == 3 && chars[i] == '?') {
        result += "5";
      } else if(i == 4 && chars[i] == '?') {
        result += "9";
      } else {
        result += chars[i];
      }
    }

    return result;
  }
}