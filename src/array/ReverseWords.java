package array;

public class ReverseWords {
    public static String reverse(String s){
        if (s==null&&s.length()==0)
            return "";
        StringBuilder stringBuilder=new StringBuilder();
        String[] strs=s.split(" ");
        for (int i=strs.length-1;i>=0;i--){
            stringBuilder.append(strs[i]).append(" ");
        }
        String res=stringBuilder.toString().trim();
        return res;
    }
}
