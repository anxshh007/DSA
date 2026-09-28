//anxshh
//This approach iterates backward from the end of the string, skipping trailing spaces and then counting characters until reaching the next space or the start of the string.
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1, l = 0;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            l++;
            i--;
        }
        return l;
    }
}