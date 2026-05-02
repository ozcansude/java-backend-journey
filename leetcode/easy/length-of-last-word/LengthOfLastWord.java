class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length()-1; 

        // fly me to the moon
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        } // buradan 'moon' kaldı

        while(i >= 0 && s.charAt(i) != ' '){
            length++;
            i--;
        }
    
    return length;

    }
}
