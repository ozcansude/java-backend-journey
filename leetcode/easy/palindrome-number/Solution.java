class Solution {
    public boolean isPalindrome(int x) {

        boolean isBoolean = true;
        int uzunluk = String.valueOf(x).length();
        
        if(x < 0)
            return false;
        else{
            String sayi = String.valueOf(x);
            for(int i = 0 ; i < uzunluk/2 ; i++){
                if(sayi.charAt(i) != sayi.charAt(uzunluk-1-i))
                    return false;
            }

        }

    return isBoolean;
    }
}
