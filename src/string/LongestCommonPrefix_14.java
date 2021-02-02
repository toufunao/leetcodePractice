package string;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0||strs==null)
            return "";
        int length=strs[0].length();
        int count=strs.length;
        for (int i=0;i<length;i++){
            char t=strs[0].charAt(i);
            for (int j=1;j<count;j++){
                if (i==strs[j].length()||strs[j].charAt(i)!=t){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
