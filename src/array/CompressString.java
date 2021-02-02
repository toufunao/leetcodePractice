package array;

public class CompressString {
    public String compress(String s){
        if (s==null&&s.length()==0)
            return "";

        StringBuilder stringBuilder=new StringBuilder();
        int count=1;
        char ch=s.charAt(0);
        for (int i=1;i<s.length();i++){
            if (ch==s.charAt(i))
                count++;
            else {
                stringBuilder.append(ch).append(count);
                count=1;
            }
        }
        stringBuilder.append(ch).append(count);
        return stringBuilder.length()>=s.length()?s:stringBuilder.toString();
    }
}
