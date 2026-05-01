class Solution {
    public String longestCommonPrefix(String[] strs) { //["flower", "flow",flight"]
        if(strs == null || strs.length == 0)
            return "";
// bu for döngüsünde bi referans alıcam ve o referansa göre kalanları kontrol edicem. ilkini aldım
        String first = strs[0];
        if(strs.length == 1)
            return first;
 
        for(int i = 0 ; i < first.length(); i++){ //['f','l','o'...]
            //bi temp belirleyip onla kıyaslarım
            char c = first.charAt(i);
            for(int j = 1 ; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return first.substring(0,i);
                }
                
            }
        }
        return first;


    }
}
